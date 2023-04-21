package com.zacboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zacboot.system.core.entity.admin.SysRole;
import com.zacboot.admin.beans.example.SysRoleExample;
import com.zacboot.admin.mapper.provider.SysRoleSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @Author zac
 * @since 2018-12-19
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @SelectProvider(type= SysRoleSqlProvider.class, method="countByExample")
    long countByExample(SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @DeleteProvider(type= SysRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @InsertProvider(type= SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @SelectProvider(type= SysRoleSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="uuid", property="uuid", jdbcType= JdbcType.VARCHAR),
            @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysRole> selectByExampleWithRowbounds(SysRoleExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @SelectProvider(type= SysRoleSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
            @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysRole> selectByExample(SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @UpdateProvider(type= SysRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role
     *
     * @mbg.generated Fri Apr 30 23:19:11 CST 2021
     */
    @UpdateProvider(type= SysRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     * @Author zac
     * @Date 2019/12/13 16:12
     * @Description: 删除角色与用户关系
     */
    @Delete("delete from sys_user_role where role_id = #{roleId}")
    void deleteRoleUserRelation(@Param("roleId") String roleId);


    /**
     * @Author zac
     * @Date 2019/12/13 16:12
     * @Description: 删除角色与权限关系
     */
    @Delete("delete from sys_role_permission where role_id = #{roleId}")
    void deleteRolePermissionRelation(@Param("roleId") String roleId);

    @Select("select * from sys_role where uuid = #{uuid}")
    SysRole queryByUuid(@Param("uuid") String roleUuid);
}
