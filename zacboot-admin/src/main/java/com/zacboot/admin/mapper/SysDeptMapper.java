package com.zacboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zacboot.system.core.entity.admin.SysDept;
import com.zacboot.admin.beans.example.SysDeptExample;
import com.zacboot.admin.mapper.provider.SysDeptSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 部门 Mapper 接口
 * <p>
 * 
 * @Author: zac
 * @Since：   2019-01-22
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@SelectProvider(type= SysDeptSqlProvider.class, method="countByExample")
	long countByExample(SysDeptExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@DeleteProvider(type=SysDeptSqlProvider.class, method="deleteByExample")
	int deleteByExample(SysDeptExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	int insert(SysDept record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@InsertProvider(type=SysDeptSqlProvider.class, method="insertSelective")
	int insertSelective(SysDept record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@SelectProvider(type=SysDeptSqlProvider.class, method="selectByExample")
	@Results({
            @Result(column = "uuid", property = "uuid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_uuid", property = "parentUuid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "depart_name", property = "departName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "leader_uuid", property = "leaderUuid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dept_address", property = "deptAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_user", property = "updateUser", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT)
    })
	List<SysDept> selectByExampleWithRowbounds(SysDeptExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@SelectProvider(type=SysDeptSqlProvider.class, method="selectByExample")
	@Results({
            @Result(column = "uuid", property = "uuid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_uuid", property = "parentUuid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "depart_name", property = "departName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dept_address", property = "deptAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "leader_uuid", property = "leaderUuid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_user", property = "updateUser", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT)
    })
	List<SysDept> selectByExample(SysDeptExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExampleSelective")
	int updateByExampleSelective(@org.apache.ibatis.annotations.Param("record") SysDept record, @org.apache.ibatis.annotations.Param("example") SysDeptExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table zacboot..sys_dept
	 *
	 * @mbg.generated Fri Apr 30 22:36:02 CST 2021
	 */
	@UpdateProvider(type= SysDeptSqlProvider.class, method="updateByExample")
	int updateByExample(@org.apache.ibatis.annotations.Param("record") SysDept record, @org.apache.ibatis.annotations.Param("example") SysDeptExample example);
	
	/**
	 * 根据用户ID查询部门集合
	 */
    List<SysDept> queryUserDeparts(@Param("userId") String userId);

	/**
	 * 根据用户名查询部门
	 *
	 * @param username
	 * @return
	 */
    List<SysDept> queryDepartsByUsername(@Param("username") String username);

	@Select("select id from sys_dept where org_code=#{orgCode}")
    String queryDepartIdByOrgCode(@Param("orgCode") String orgCode);

    @Select("select id,parent_uuid from sys_dept where id=#{departId}")
    SysDept getParentDepartId(@Param("departId") String departId);

	/**
	 *  根据部门Id查询,当前和下级所有部门IDS
	 * @param departId
	 * @return
	 */
	List<String> getSubDepIdsByDepId(@Param("departId") String departId);

	/**
	 * 根据部门编码获取部门下所有IDS
	 * @param orgCodes
	 * @return
	 */
	List<String> getSubDepIdsByOrgCodes(@org.apache.ibatis.annotations.Param("orgCodes") String[] orgCodes);

}
