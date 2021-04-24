package com.zac.flycloud.mapper;

import com.zac.flycloud.dto.SysUserDTO;
import com.zac.flycloud.dto.example.SysUserDTOExample;
import java.util.List;
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

public interface SysUserDTOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type=SysUserDTOSqlProvider.class, method="countByExample")
    long countByExample(SysUserDTOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @DeleteProvider(type=SysUserDTOSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserDTOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @Insert({
        "insert into sys_user (uuid, username, ",
        "`password`, realname, ",
        "avatar, nickname, ",
        "mail, phone, create_user, ",
        "create_time, update_user, ",
        "update_time, deleted)",
        "values (#{uuid,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{mail,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=BIT})"
    })
    int insert(SysUserDTO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @InsertProvider(type=SysUserDTOSqlProvider.class, method="insertSelective")
    int insertSelective(SysUserDTO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type=SysUserDTOSqlProvider.class, method="selectByExample")
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
    List<SysUserDTO> selectByExampleWithRowbounds(SysUserDTOExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type=SysUserDTOSqlProvider.class, method="selectByExample")
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
    List<SysUserDTO> selectByExample(SysUserDTOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @UpdateProvider(type=SysUserDTOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUserDTO record, @Param("example") SysUserDTOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @UpdateProvider(type=SysUserDTOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUserDTO record, @Param("example") SysUserDTOExample example);
}