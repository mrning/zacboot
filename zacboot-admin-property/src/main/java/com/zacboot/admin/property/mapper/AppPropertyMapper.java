package com.zacboot.admin.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zacboot.admin.property.dto.example.AppPropertyExample;
import com.zacboot.system.core.entity.administration.AppProperty;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AppPropertyMapper extends BaseMapper<AppProperty> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @SelectProvider(type=AppPropertySqlProvider.class, method="countByExample")
    long countByExample(AppPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @DeleteProvider(type=AppPropertySqlProvider.class, method="deleteByExample")
    int deleteByExample(AppPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @Insert({
        "insert into app_property (uuid, property_no, ",
        "property_name, price, ",
        "use_total_count, remain_count, ",
        "spec_model, buy_date, ",
        "use_date, type_code, ",
        "use_dept_uuid, use_dept_name, ",
        "owner_uuid, owner_name, ",
        "`location`, remark, ",
        "create_user, create_time, ",
        "update_user, update_time, ",
        "deleted)",
        "values (#{uuid,jdbcType=VARCHAR}, #{propertyNo,jdbcType=VARCHAR}, ",
        "#{propertyName,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{useTotalCount,jdbcType=INTEGER}, #{remainCount,jdbcType=INTEGER}, ",
        "#{specModel,jdbcType=VARCHAR}, #{buyDate,jdbcType=TIMESTAMP}, ",
        "#{useDate,jdbcType=TIMESTAMP}, #{typeCode,jdbcType=VARCHAR}, ",
        "#{useDeptUuid,jdbcType=VARCHAR}, #{useDeptName,jdbcType=VARCHAR}, ",
        "#{ownerUuid,jdbcType=VARCHAR}, #{ownerName,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleted,jdbcType=BIT})"
    })
    int insert(AppProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @InsertProvider(type=AppPropertySqlProvider.class, method="insertSelective")
    int insertSelective(AppProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @SelectProvider(type=AppPropertySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_no", property="propertyNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_name", property="propertyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="use_total_count", property="useTotalCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remain_count", property="remainCount", jdbcType=JdbcType.INTEGER),
        @Result(column="spec_model", property="specModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_date", property="buyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="use_date", property="useDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_dept_uuid", property="useDeptUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_dept_name", property="useDeptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_uuid", property="ownerUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_name", property="ownerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<AppProperty> selectByExampleWithRowbounds(AppPropertyExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @SelectProvider(type=AppPropertySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_no", property="propertyNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_name", property="propertyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="use_total_count", property="useTotalCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remain_count", property="remainCount", jdbcType=JdbcType.INTEGER),
        @Result(column="spec_model", property="specModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_date", property="buyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="use_date", property="useDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_dept_uuid", property="useDeptUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_dept_name", property="useDeptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_uuid", property="ownerUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_name", property="ownerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<AppProperty> selectByExample(AppPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @UpdateProvider(type=AppPropertySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppProperty record, @Param("example") AppPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..app_property
     *
     * @mbg.generated Wed Apr 26 16:20:54 CST 2023
     */
    @UpdateProvider(type=AppPropertySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppProperty record, @Param("example") AppPropertyExample example);
}