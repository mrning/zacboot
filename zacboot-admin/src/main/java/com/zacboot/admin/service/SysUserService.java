package com.zacboot.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.zacboot.admin.beans.entity.SysUser;
import com.zacboot.admin.beans.vos.request.RegisRequest;
import com.zacboot.admin.beans.vos.request.UserRequest;
import com.zacboot.common.base.basebeans.PageResult;
import com.zacboot.common.base.basebeans.Result;

/**
 * AutoCreateFile
 * @date 2021年4月24日星期六
 * @author zac
 */
public interface SysUserService extends SysBaseService<SysUser> {
    Integer add(SysUser sysUser);

    Integer del(SysUser sysUser);

    Integer update(SysUser sysUser, String token);

    PageResult<SysUser> queryPage(UserRequest userRequest);

    /**
     * 根据用户账号查询用户信息
     *
     * @param username
     * @return
     */
    SysUser getUserByName(String username);

    /**
     * 根据手机号获取用户名和密码
     */
    SysUser getUserByPhone(String phone);

    /**
     * 根据邮箱获取用户
     */
    SysUser getUserByEmail(String mail);

    /**
     * 重置密码
     *
     * @param username
     * @param oldpassword
     * @param newpassword
     * @param confirmpassword
     * @return
     */
    Result<?> resetPassword(String username, String oldpassword, String newpassword, String confirmpassword);

    /**
     * 修改密码
     *
     * @param sysUser
     * @return
     */
    Result<?> changePassword(SysUser sysUser);

    /**
     * 校验用户是否有效
     *
     * @param sysUser
     * @return
     */
    Result checkUserIsEffective(SysUser sysUser);

    /**
     * 查詢用戶信息
     * @param sysUser
     * @return
     * @throws Exception
     */
    JSONObject userInfo(SysUser sysUser);

    /**
     * regis
     */
    boolean register(RegisRequest regisRequest);

    /**
     * 登出
     */
    boolean logout(String token);
}