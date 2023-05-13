package com.zacboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zacboot.system.core.entity.admin.SysRole;
import com.zacboot.system.core.entity.admin.SysUserRole;
import com.zacboot.admin.beans.example.SysUserRoleExample;
import com.zacboot.admin.mapper.provider.SysUserRoleDTOSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @Author zac
 * @since 2018-12-21
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@SelectProvider(type= SysUserRoleDTOSqlProvider.class, method="countByExample")
	long countByExample(SysUserRoleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@DeleteProvider(type=SysUserRoleDTOSqlProvider.class, method="deleteByExample")
	int deleteByExample(SysUserRoleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	int insert(SysUserRole record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@InsertProvider(type=SysUserRoleDTOSqlProvider.class, method="insertSelective")
	int insertSelective(SysUserRole record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@SelectProvider(type=SysUserRoleDTOSqlProvider.class, method="selectByExample")
	@Results({
			@Result(column="uuid", property="uuid", jdbcType= JdbcType.VARCHAR),
			@Result(column="user_uuid", property="userUuid", jdbcType=JdbcType.VARCHAR),
			@Result(column="role_uuid", property="roleUuid", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
	})
	List<SysUserRole> selectByExampleWithRowbounds(SysUserRoleExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@SelectProvider(type=SysUserRoleDTOSqlProvider.class, method="selectByExample")
	@Results({
			@Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
			@Result(column="user_uuid", property="userUuid", jdbcType=JdbcType.VARCHAR),
			@Result(column="role_uuid", property="roleUuid", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
	})
	List<SysUserRole> selectByExample(SysUserRoleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@UpdateProvider(type=SysUserRoleDTOSqlProvider.class, method="updateByExampleSelective")
	int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_user_role
	 *
	 * @mbg.generated Fri Apr 30 23:30:35 CST 2021
	 */
	@UpdateProvider(type=SysUserRoleDTOSqlProvider.class, method="updateByExample")
	int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

	@Select("select * from sys_role where uuid in (select role_uuid from sys_user_role where user_uuid = (select uuid from sys_user where username=#{username} and deleted = 0))")
	List<SysRole> getRoleByUserName(@Param("username") String username);

	@Select("select uuid from sys_role where uuid in (select role_uuid from sys_user_role where user_uuid = (select uuid from sys_user where username=#{username} and deleted = 0))")
	List<String> getRoleIdByUserName(@Param("username") String username);

}
