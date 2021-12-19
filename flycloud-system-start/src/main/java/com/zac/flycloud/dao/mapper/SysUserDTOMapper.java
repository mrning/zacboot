package com.zac.flycloud.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zac.flycloud.bean.dto.SysUserDTO;
import com.zac.flycloud.bean.dto.example.SysUserDTOExample;
import com.zac.flycloud.dao.mapper.provider.SysUserDTOSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysUserDTOMapper extends BaseMapper<SysUserDTO>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flycloud..sys_user
     *
     * @mbg.generated Sat Apr 24 17:24:37 CST 2021
     */
    @SelectProvider(type= SysUserDTOSqlProvider.class, method="countByExample")
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