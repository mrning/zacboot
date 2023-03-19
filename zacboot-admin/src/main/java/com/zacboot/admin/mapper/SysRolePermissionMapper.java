package com.zacboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zac.system.core.entity.admin.SysRolePermission;
import com.zacboot.admin.beans.example.SysRolePermissionExample;
import com.zacboot.admin.mapper.provider.SysRolePermissionSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @SelectProvider(type= SysRolePermissionSqlProvider.class, method="countByExample")
    long countByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @DeleteProvider(type=SysRolePermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @Insert({
        "insert into sys_role_permission (role_uuid, permission_uuid, ",
        "uuid, create_user, ",
        "create_time, update_user, ",
        "update_time, deleted)",
        "values (#{roleUuid,jdbcType=VARCHAR}, #{permissionUuid,jdbcType=VARCHAR}, ",
        "#{uuid,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=BIT})"
    })
    int insert(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @InsertProvider(type=SysRolePermissionSqlProvider.class, method="insertSelective")
    int insertSelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @SelectProvider(type=SysRolePermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_uuid", property="roleUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_uuid", property="permissionUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysRolePermission> selectByExampleWithRowbounds(SysRolePermissionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @SelectProvider(type=SysRolePermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_uuid", property="roleUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_uuid", property="permissionUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @UpdateProvider(type=SysRolePermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    @UpdateProvider(type=SysRolePermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);
}