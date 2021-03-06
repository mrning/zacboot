package com.zac.flycloud.autocode.service.impl;

import cn.hutool.core.lang.UUID;
import com.zac.flycloud.autocode.service.MybatisGeneratorService;
import com.zac.flycloud.bean.vos.request.MybatisGeneratorRequest;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.*;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.zac.flycloud.autocode.constants.MgtConstant.*;

@Service
public class MybatisGeneratorServiceImpl implements MybatisGeneratorService {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String dbUserName;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    public static final String API_PACKAGE = ".api.";

    @Override
    public String doDenerator(MybatisGeneratorRequest mybatisGeneratorRequest)  {
        Configuration config = new Configuration();

        // conditional:*这是默认值*,这个模型和下面的hierarchical类似，除了如果那个单独的类将只包含一个字段，将不会生成一个单独的类。
        // 因此,如果一个表的主键只有一个字段,那么不会为该字段生成单独的实体类,会将该字段合并到基本实体类中。
        // flat:该模型为每一张表只生成一个实体类。这个实体类包含表中的所有字段。**这种模型最简单，推荐使用。**
        // hierarchical:如果表有主键,那么该模型会产生一个单独的主键实体类,如果表还有BLOB字段，
        // 则会为表生成一个包含所有BLOB字段的单独的实体类,然后为所有其他的字段生成一个单独的实体类。 MBG会在所有生成的实体类之间维护一个继承关系。
        Context context = new Context(ModelType.FLAT);
        context.setId(UUID.randomUUID().toString(true));
        context.setTargetRuntime("MyBatis3");
        // 设置分隔符 前后分隔符 保留字符使用`分隔
        context.addProperty("autoDelimitKeywords","true");
        context.addProperty("beginningDelimiter","`");
        context.addProperty("endingDelimiter","`");
        context.addProperty("tableName",mybatisGeneratorRequest.getTableName());
        context.addProperty("dataBaseName",mybatisGeneratorRequest.getDataBaseName());

        // 添加插件
        addPlugins(context,mybatisGeneratorRequest.getDesc(),mybatisGeneratorRequest.getPlatform().getValue());

        // 配置jdbc连接
        buildConnection(context);

        // 配置要生成代码的表
        buildTables(context);

        //生成注释 默认实现：DefaultCommentGenerator

        // 用来控制生成的实体类
        buildJavaModel(context);

        // 设置mapper接口的生成
        buildMapper(context);

        try {
            config.addContext(context);
            // 允许覆盖生成的文件
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, new ArrayList<>());
            ProgressCallback progressCallback = new VerboseProgressCallback();
            myBatisGenerator.generate(progressCallback);
        } catch (InvalidConfigurationException | SQLException | IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
        return "success";
    }

    private void addPlugins(Context context,String desc, String platform) {
        // 添加自定义插件 分页插件
        PluginConfiguration pluginRowBoundsPlugin = new PluginConfiguration();
        pluginRowBoundsPlugin.setConfigurationType("org.mybatis.generator.plugins.RowBoundsPlugin");
        context.addPluginConfiguration(pluginRowBoundsPlugin);
        // controller生成插件
        PluginConfiguration controllerPlugin = new PluginConfiguration();
        controllerPlugin.setConfigurationType(TARGETPACKAGE+".genplugins.ControllerGenPlugin");
        controllerPlugin.addProperty("controllerPath","controller\\"+TARGETPROJECT);
        controllerPlugin.addProperty("controllerPackage",TARGETPACKAGE+API_PACKAGE+platform);
        controllerPlugin.addProperty("controllerPlatform", platform);
        controllerPlugin.addProperty("controllerDesc", desc);
        context.addPluginConfiguration(controllerPlugin);
        // service生成插件
        PluginConfiguration servicePlugin = new PluginConfiguration();
        servicePlugin.setConfigurationType(TARGETPACKAGE+".genplugins.ServiceGenPlugin");
        servicePlugin.addProperty("servicePath","service\\"+TARGETPROJECT);
        servicePlugin.addProperty("servicePackage",TARGETPACKAGE_SERVICE);
        context.addPluginConfiguration(servicePlugin);
        // dao生成插件
        PluginConfiguration daoPlugin = new PluginConfiguration();
        daoPlugin.setConfigurationType(TARGETPACKAGE+".genplugins.DaoGenPlugin");
        daoPlugin.addProperty("daoPath","dao\\"+TARGETPROJECT);
        daoPlugin.addProperty("daoPackage",TARGETPACKAGE_DAO);
        context.addPluginConfiguration(daoPlugin);
    }

    private void buildMapper(Context context) {
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setConfigurationType("ANNOTATEDMAPPER");
        javaClientGeneratorConfiguration.setTargetProject("dao\\"+TARGETPROJECT);
        javaClientGeneratorConfiguration.setTargetPackage(TARGETPACKAGE_MAPPER);
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
    }

    private void buildJavaModel(Context context) {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject("bean\\"+TARGETPROJECT);
        javaModelGeneratorConfiguration.setTargetPackage(TARGETPACKAGE_DTO);
        javaModelGeneratorConfiguration.addProperty("rootClass",TARGETPACKAGE+".basebean.BaseDTO");
        javaModelGeneratorConfiguration.addProperty("exampleTargetPackage",javaModelGeneratorConfiguration.getTargetPackage()+".example");
        javaModelGeneratorConfiguration.addProperty("trimStrings","true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
    }

    private void buildTables(Context context) {
        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(context.getProperty("tableName"));
        GeneratedKey generatedKey = new GeneratedKey("id","JDBC",true,"post");
        tableConfiguration.setGeneratedKey(generatedKey);
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("id"));
        // 生成代码逻辑需要制定库名，否则会查找全部库的同名表然后被覆盖生成不需要的DTO
        tableConfiguration.setCatalog(context.getProperty("dataBaseName"));
        tableConfiguration.addProperty("ignoreQualifiersAtRuntime","true");
        context.addTableConfiguration(tableConfiguration);
    }

    private void buildConnection(Context context) {
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(dbUrl);
        jdbcConnectionConfiguration.setDriverClass(driverClassName);
        jdbcConnectionConfiguration.setUserId(dbUserName);
        jdbcConnectionConfiguration.setPassword(dbPassword);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
    }
}
