package com.zacboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zac.system.core.entity.admin.SysUser;
import com.zacboot.admin.beans.example.SysUserExample;
import com.zacboot.admin.mapper.provider.SysUserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 用户mapper
 * 所有需要user表中数据作为查询条件的mapper都放这里
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type= SysUserSqlProvider.class, method="countByExample")
    long countByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @DeleteProvider(type= SysUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot.sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @InsertProvider(type= SysUserSqlProvider.class, method="insertSelective")
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type= SysUserSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="uuid", property="uuid", jdbcType= JdbcType.VARCHAR),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
            @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
            @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysUser> selectByExampleWithRowbounds(SysUserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type= SysUserSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
            @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
            @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysUser> selectByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @UpdateProvider(type= SysUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @UpdateProvider(type= SysUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * 通过用户uuid查询用户信息
     * @param uuid
     * @return
     */
    @Select("select * from sys_user where uuid = #{uuid} and deleted = 0")
    SysUser getUserByUuid(@Param("uuid") String uuid);

    /**
     * 通过用户账号查询用户信息
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{username} and deleted = 0")
    SysUser getUserByName(@Param("username") String username);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    @Select("select * from sys_user where phone = #{phone} and deleted = 0")
    SysUser getUserByPhone(@Param("phone") String phone);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    @Select("select * from sys_user where mail = #{mail} and deleted = 0")
    SysUser getUserByEmail(@Param("mail") String mail);

}
