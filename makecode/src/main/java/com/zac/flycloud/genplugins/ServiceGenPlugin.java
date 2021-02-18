package com.zac.flycloud.genplugins;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.Context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static com.zac.flycloud.constants.MgtConstant.*;

/**
 * Service和实现类的创建插件
 */
public class ServiceGenPlugin extends PluginAdapter {
    private String servicePath = "";
    private String servicePackage = "";
    private String daoName = "";
    private String dtoName = "";

    public ServiceGenPlugin() {
        super();
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        List<GeneratedJavaFile> generatedJavaFiles = new ArrayList<>();
        servicePath = this.properties.getProperty("servicePath");
        servicePackage = this.properties.getProperty("servicePackage");
        // dto名称
        dtoName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        // base文件名
        String baseDomainName = dtoName.replace(DTO_SUFFIX,"");
        // dao名称 首字符小写
        daoName = StringUtils.firstToLowerCase(baseDomainName)+DAO_SUFFIX;

        generatedJavaFiles.add(buildServiceFile(baseDomainName,servicePackage+"."+ baseDomainName +SERVICE_SUFFIX));
        generatedJavaFiles.add(buildServiceFile(baseDomainName,servicePackage+".impl."+ baseDomainName +SERVICE_SUFFIX+IMPL_SUFFIX));
        return generatedJavaFiles;
    }

    private GeneratedJavaFile buildServiceFile(String baseDomainName,String fullFileName) {

        if(fullFileName.contains(IMPL_SUFFIX)){
            TopLevelClass genClass = new TopLevelClass(fullFileName);
            genClass.setVisibility(JavaVisibility.PUBLIC);
            genClass.addJavaDocLine("/**\n" +
                    " * AutoCreateFile\n" +
                    " * @date "+ LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) +"\n" +
                    " * @author zac\n" +
                    " */");
            genClass.addImportedType(new FullyQualifiedJavaType("lombok.extern.slf4j.Slf4j"));
            genClass.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.factory.annotation.*"));
            genClass.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Service"));
            genClass.addImportedType(new FullyQualifiedJavaType("org.springframework.util.Assert"));
            genClass.addImportedType(new FullyQualifiedJavaType("cn.hutool.db.Page"));
            genClass.addImportedType(new FullyQualifiedJavaType("cn.hutool.db.PageResult"));
            genClass.addImportedType(new FullyQualifiedJavaType("cn.hutool.core.bean.BeanUtil"));
            genClass.addImportedType(new FullyQualifiedJavaType(servicePackage+"."+baseDomainName+SERVICE_SUFFIX));
            genClass.addImportedType(new FullyQualifiedJavaType(TARGETPACKAGE_DTO+"."+dtoName));


            genClass.addAnnotation(ANNOTATION_SL4J);
            genClass.addAnnotation(ANNOTATION_SERVICE);
            genClass.addSuperInterface(new FullyQualifiedJavaType(baseDomainName+SERVICE_SUFFIX));

            createField(baseDomainName,genClass);
            createMethod("add", genClass);
            createMethod("del", genClass);
            createMethod("update", genClass);
            createMethod("queryPage", genClass);

            return new GeneratedJavaFile(genClass, servicePath, new DefaultJavaFormatter());
        }else{
            Interface genInterface = new Interface(fullFileName);
            genInterface.setVisibility(JavaVisibility.PUBLIC);
            genInterface.addJavaDocLine("/**\n" +
                    " * AutoCreateFile\n" +
                    " * @date "+ LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) +"\n" +
                    " * @author zac\n" +
                    " */");
            genInterface.addImportedType(new FullyQualifiedJavaType("cn.hutool.db.PageResult"));
            genInterface.addImportedType(new FullyQualifiedJavaType(TARGETPACKAGE_DTO+"."+dtoName));

            createMethod("add", genInterface);
            createMethod("del", genInterface);
            createMethod("update", genInterface);
            createMethod("queryPage", genInterface);

            return new GeneratedJavaFile(genInterface, servicePath, new DefaultJavaFormatter());
        }

    }

    private void createField(String domainObjectName, TopLevelClass topLevelClass) {
        topLevelClass.addImportedType(TARGETPACKAGE+".dao."+ domainObjectName+DAO_SUFFIX);
        Field field = new Field(daoName ,new FullyQualifiedJavaType(domainObjectName +DAO_SUFFIX));
        field.addAnnotation(ANNOTATION_AUTOWIRED);
        field.setVisibility(JavaVisibility.PRIVATE);
        topLevelClass.addField(field);
    }

    private void createMethod(String methodName, CompilationUnit compilationUnit) {
        String firstLowerDtoName = StringUtils.firstToLowerCase(dtoName);
        String firstLowerDaoName = StringUtils.firstToLowerCase(daoName);
        Method method = new Method(methodName);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(
                new FullyQualifiedJavaType(TARGETPACKAGE_DTO+"."+dtoName),
                firstLowerDtoName));
        if(methodName.contains("queryPage")){
            method.setReturnType(new FullyQualifiedJavaType("PageResult<"+dtoName+">"));
            method.addBodyLine("PageResult<"+dtoName+"> pageResult = new PageResult<>();");
            method.addBodyLine("pageResult.addAll("+firstLowerDaoName+"."+methodName+"("+
                    firstLowerDtoName+",new Page("+firstLowerDtoName+".getPageNumber(),"+firstLowerDtoName+".getPageSize())));");
            method.addBodyLine("pageResult.setTotal("+firstLowerDaoName+"."+methodName+"Count("+firstLowerDtoName+").intValue());");
            method.addBodyLine("return pageResult;");
        }else{
            method.setReturnType(new FullyQualifiedJavaType("Integer"));
            if(methodName.contains("del")){
                method.addBodyLine("Assert.isTrue(BeanUtil.isEmpty("+firstLowerDtoName+"),\"不能全部属性为空，会删除全表数据\");");
            }
            method.addBodyLine("return "+firstLowerDaoName+"."+methodName+"("+firstLowerDtoName+");");
        }

        if (compilationUnit instanceof TopLevelClass) {
            ((TopLevelClass) compilationUnit).addMethod(method);
        } else {
            method.setAbstract(true);
            ((Interface) compilationUnit).addMethod(method);
        }
    }
}