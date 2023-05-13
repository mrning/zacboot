package com.zacboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zacboot.system.core.entity.admin.SysPermission;
import com.zacboot.admin.beans.example.SysPermissionExample;
import com.zacboot.admin.mapper.provider.SysPermissionSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @SelectProvider(type= SysPermissionSqlProvider.class, method="countByExample")
    long countByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @DeleteProvider(type=SysPermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @Insert({
        "insert into sys_permission (uuid, parent_uuid, ",
        "`name`, code, icon, ",
        "component, url, ",
        "redirect, sort_no, ",
        "menu_type, hidden, create_user, ",
        "create_time, update_user, ",
        "update_time, deleted)",
        "values (#{uuid,jdbcType=VARCHAR}, #{parentUuid,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
        "#{component,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{redirect,jdbcType=VARCHAR}, #{sortNo,jdbcType=INTEGER}, ",
        "#{menuType,jdbcType=INTEGER}, #{hidden,jdbcType=BIT}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=BIT})"
    })
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @InsertProvider(type=SysPermissionSqlProvider.class, method="insertSelective")
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @SelectProvider(type=SysPermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_uuid", property="parentUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="redirect", property="redirect", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_no", property="sortNo", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.INTEGER),
        @Result(column="hidden", property="hidden", jdbcType=JdbcType.BIT),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysPermission> selectByExampleWithRowbounds(SysPermissionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @SelectProvider(type=SysPermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_uuid", property="parentUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="redirect", property="redirect", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_no", property="sortNo", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.INTEGER),
        @Result(column="hidden", property="hidden", jdbcType=JdbcType.BIT),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysPermission> selectByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @UpdateProvider(type=SysPermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_permission
     *
     * @mbg.generated Thu Dec 22 21:58:54 CST 2022
     */
    @UpdateProvider(type=SysPermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);
}