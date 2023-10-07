package com.lqjk.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqjk.admin.beans.example.SysDictExample;
import com.lqjk.admin.mapper.provider.SysDictSqlProvider;
import java.util.List;

import com.lqjk.base.bizentity.SysDict;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface SysDictMapper extends BaseMapper<SysDict> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @SelectProvider(type= SysDictSqlProvider.class, method="countByExample")
    long countByExample(SysDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @DeleteProvider(type=SysDictSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @Insert({
        "insert into sys_dict (uuid, code, ",
        "`name`, sort_no, parent_code, ",
        "parent_name, create_user, ",
        "create_time, update_user, ",
        "update_time, deleted)",
        "values (#{uuid,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{sortNo,jdbcType=VARCHAR}, #{parentCode,jdbcType=VARCHAR}, ",
        "#{parentName,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=BIT})"
    })
    int insert(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @InsertProvider(type=SysDictSqlProvider.class, method="insertSelective")
    int insertSelective(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @SelectProvider(type=SysDictSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_no", property="sortNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysDict> selectByExampleWithRowbounds(SysDictExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @SelectProvider(type=SysDictSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_no", property="sortNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysDict> selectByExample(SysDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_dict
     *
     * @mbg.generated Wed Apr 26 13:35:17 CST 2023
     */
    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    @Select({"select * from sys_dict where deleted = false"})
    List<SysDict> selectAll();
}