package com.zac.flycloud.sys;

import com.zac.flycloud.basebean.DataResponseResult;
import com.zac.flycloud.entity.tablemodel.SysUser;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService extends IService<SysUser>{

    /**
     * 重置密码
     *
     * @param username
     * @param oldpassword
     * @param newpassword
     * @param confirmpassword
     * @return
     */
    DataResponseResult<?> resetPassword(String username, String oldpassword, String newpassword, String confirmpassword);

    /**
     * 修改密码
     *
     * @param sysUser
     * @return
     */
    DataResponseResult<?> changePassword(SysUser sysUser);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    boolean deleteUser(String userId);

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    boolean deleteBatchUsers(String userIds);

    SysUser getUserByName(String username);

    /**
     * 添加用户和用户角色关系
     * @param user
     * @param roles
     */
    void addUserWithRole(SysUser user, String roles);


    /**
     * 修改用户和用户角色关系
     * @param user
     * @param roles
     */
    void editUserWithRole(SysUser user, String roles);

    /**
     * 获取用户的授权角色
     * @param username
     * @return
     */
    List<String> getRole(String username);

    /**
     * 查询用户信息包括 部门信息
     * @param username
     * @return
     */
//    public SysUserCacheInfo getCacheUser(String username);

    /**
     * 根据部门Id查询
     * @param
     * @return
     */
    IPage<SysUser> getUserByDepId(Page<SysUser> page, String departId, String username);

    /**
     * 根据部门Ids查询
     * @param
     * @return
     */
    IPage<SysUser> getUserByDepIds(Page<SysUser> page, List<String> departIds, String username);

    /**
     * 根据 userIds查询，查询用户所属部门的名称（多个部门名逗号隔开）
     * @param
     * @return
     */
    Map<String,String> getDepNamesByUserIds(List<String> userIds);

    /**
     * 根据部门 Id 和 QueryWrapper 查询
     *
     * @param page
     * @param departId
     * @param queryWrapper
     * @return
     */
    IPage<SysUser> getUserByDepartIdAndQueryWrapper(Page<SysUser> page, String departId, QueryWrapper<SysUser> queryWrapper);


    /**
     * 根据角色Id查询
     * @param
     * @return
     */
    IPage<SysUser> getUserByRoleId(Page<SysUser> page, String roleId, String username);

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    Set<String> getUserRolesSet(String username);

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    Set<String> getUserPermissionsSet(String username);

    /**
     * 根据手机号获取用户名和密码
     */
    SysUser getUserByPhone(String phone);


    /**
     * 根据邮箱获取用户
     */
    SysUser getUserByEmail(String email);


    /**
     * 添加用户和用户部门关系
     * @param user
     * @param selectedParts
     */
    void addUserWithDepart(SysUser user, String selectedParts);

    /**
     * 编辑用户和用户部门关系
     * @param user
     * @param departs
     */
    void editUserWithDepart(SysUser user, String departs);

    /**
     * 校验用户是否有效
     * @param sysUser
     * @return
     */
    DataResponseResult checkUserIsEffective(SysUser sysUser);

    /**
     * 查询被逻辑删除的用户
     */
    List<SysUser> queryLogicDeleted();

    /**
     * 查询被逻辑删除的用户（可拼装查询条件）
     */
    List<SysUser> queryLogicDeleted(LambdaQueryWrapper<SysUser> wrapper);

    /**
     * 还原被逻辑删除的用户
     */
    boolean revertLogicDeleted(List<String> userIds, SysUser updateEntity);

    /**
     * 彻底删除被逻辑删除的用户
     */
    boolean removeLogicDeleted(List<String> userIds);

    /**
     * 更新手机号、邮箱空字符串为 null
     */
    @Transactional(rollbackFor = Exception.class)
    boolean updateNullPhoneEmail();

    /**
     * 保存第三方用户信息
     * @param sysUser
     */
    void saveThirdUser(SysUser sysUser);

    /**
     * 根据部门Ids查询
     * @param
     * @return
     */
    List<SysUser> queryByDepIds(List<String> departIds, String username);
}
