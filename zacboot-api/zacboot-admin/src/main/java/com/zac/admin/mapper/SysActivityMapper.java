package com.zac.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zac.admin.beans.example.SysActivityExample;
import com.zac.admin.mapper.provider.SysActivitySqlProvider;
import com.zac.base.bizentity.SysActivity;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysActivityMapper extends BaseMapper<SysActivity> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @SelectProvider(type= SysActivitySqlProvider.class, method="countByExample")
    long countByExample(SysActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @DeleteProvider(type=SysActivitySqlProvider.class, method="deleteByExample")
    int deleteByExample(SysActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @Insert({
        "insert into sys_activity (uuid, act_name, ",
        "act_desc, link_url, ",
        "user_tags, start_time, ",
        "end_time, open_window_url, ",
        "index_open_url, create_user, ",
        "create_time, update_user, ",
        "update_time, deleted)",
        "values (#{uuid,jdbcType=VARCHAR}, #{actName,jdbcType=VARCHAR}, ",
        "#{actDesc,jdbcType=VARCHAR}, #{linkUrl,jdbcType=VARCHAR}, ",
        "#{userTags,jdbcType=VARCHAR}, #{startTime,jdbcType=VARCHAR}, ",
        "#{endTime,jdbcType=VARCHAR}, #{openWindowUrl,jdbcType=VARCHAR}, ",
        "#{indexOpenUrl,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=BIT})"
    })
    int insert(SysActivity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @InsertProvider(type=SysActivitySqlProvider.class, method="insertSelective")
    int insertSelective(SysActivity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @SelectProvider(type=SysActivitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_name", property="actName", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_desc", property="actDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="link_url", property="linkUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_tags", property="userTags", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_window_url", property="openWindowUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="index_open_url", property="indexOpenUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT)
    })
    List<SysActivity> selectByExample(SysActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @UpdateProvider(type=SysActivitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysActivity record, @Param("example") SysActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot-admin..sys_activity
     *
     * @mbg.generated Mon Oct 30 15:28:29 CST 2023
     */
    @UpdateProvider(type=SysActivitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysActivity record, @Param("example") SysActivityExample example);
}