package com.zacboot.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.db.Page;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zacboot.system.core.response.admin.SysDeptResponse;
import com.zacboot.system.core.response.admin.SysRoleResponse;
import com.zacboot.system.core.response.admin.SysUserDeptAndRoleInfo;
import com.zacboot.system.core.entity.admin.*;
import com.zacboot.system.core.request.sso.SsoLoginRequest;
import com.zacboot.system.core.request.sso.SsoLogoutRequest;
import com.zacboot.system.core.response.weixin.QwUserVo;
import com.zacboot.admin.beans.constants.AdminConstants;
import com.zacboot.admin.beans.vos.request.RegisRequest;
import com.zacboot.admin.beans.vos.request.UserAddRequest;
import com.zacboot.system.core.request.admin.UserRequest;
import com.zacboot.admin.beans.vos.request.UserUpdateRequest;
import com.zacboot.admin.beans.vos.response.SysUserResponse;
import com.zacboot.admin.dao.SysUserDao;
import com.zacboot.admin.feign.SsoServiceFeign;
import com.zacboot.admin.feign.WeixinApiFeign;
import com.zacboot.admin.mapper.SysUserMapper;
import com.zacboot.admin.service.*;
import com.zacboot.common.base.basebeans.PageResult;
import com.zacboot.common.base.basebeans.Result;
import com.zacboot.common.base.constants.CommonConstant;
import com.zacboot.common.base.constants.RedisKey;
import com.zacboot.common.base.utils.PasswordUtil;
import com.zacboot.common.base.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AutoCreateFile
 *
 * @author zac
 * @date 2021年4月24日星期六
 */
@Slf4j
@Service
public class SysUserServiceImpl extends SysBaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserDeptService sysUserDeptService;

    @Autowired
    private SsoServiceFeign ssoServiceFeign;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private WeixinApiFeign weixinApiFeign;

    public Integer add(UserAddRequest userAddRequest) {
        SysUser sysUser = SysUser.convertByRequest(userAddRequest);
        sysUser.setUuid(UUID.randomUUID().toString(Boolean.TRUE));
        if (!CollectionUtils.isEmpty(userAddRequest.getRoleUuids())) {
            sysUserRoleService.updateByUserUuid(sysUser.getUuid(), userAddRequest.getRoleUuids());
        }
        if (!CollectionUtils.isEmpty(userAddRequest.getDeptUuids())){
            sysUserDeptService.updateByUserUuid(sysUser.getUuid(), userAddRequest.getDeptUuids());
        }
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(PasswordUtil.getPasswordEncode(sysUser.getPassword()));
        }
        return sysUserDao.add(sysUser);
    }

    public Integer del(SysUser sysUser) {
        Assert.isTrue(StringUtils.isNotBlank(sysUser.getUuid()), "参数异常，删除失败");
        Assert.isTrue(BeanUtil.isNotEmpty(sysUser), "不能全部属性为空");
        sysUserRoleService.delByUserUuid(sysUser.getUuid());
        sysUserDeptService.delByUserUuid(sysUser.getUuid());
        return sysUserDao.del(sysUser);
    }

    public Integer update(UserUpdateRequest userUpdateRequest, String token) {
        Assert.isTrue(StringUtils.isNotBlank(userUpdateRequest.getUuid()), "参数异常，更新失败");
        SysUser sysUser = SysUser.convertByRequest(userUpdateRequest);

        if (!CollectionUtils.isEmpty(userUpdateRequest.getRoleUuids())) {
            sysUserRoleService.updateByUserUuid(sysUser.getUuid(), userUpdateRequest.getRoleUuids());
        }
        if (!CollectionUtils.isEmpty(userUpdateRequest.getDeptUuids())){
            sysUserDeptService.updateByUserUuid(sysUser.getUuid(), userUpdateRequest.getDeptUuids());
        }

        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(PasswordUtil.getPasswordEncode(sysUser.getPassword()));
            SysUser sysUserCache = (SysUser) redisUtil.get(RedisKey.LOGIN_TOKEN + ":" + token);
            if (sysUserCache != null && sysUserCache.getUuid().equals(sysUser.getUuid())) {
                // 如果密码修改则用户退出重新登录
                logout(token);
            }
        }
        return sysUserDao.update(sysUser);
    }

    public PageResult<SysUserResponse> queryPage(UserRequest userRequest) {
        PageResult<SysUserResponse> pageResult = new PageResult<>();
        List<SysUserResponse> sysUsers = sysUserDao.queryPage(userRequest, new Page(userRequest.getPageNumber(), userRequest.getPageSize()))
                .stream().map(sysUser -> {
                    SysUserResponse sysUserResponse = SysUserResponse.convertByEntity(sysUser);
                    sysUserResponse.setRoleUuids(sysUserRoleService.queryRolesByUserUuid(sysUser.getUuid()).stream().map(SysUserRole::getRoleUuid).collect(Collectors.toList()));
                    sysUserResponse.setDeptUuids(sysUserDeptService.queryDeptsByUserUuid(sysUser.getUuid()).stream().map(SysUserDept::getDeptUuid).collect(Collectors.toList()));
                    return sysUserResponse;
                }).collect(Collectors.toList());
        pageResult.setDataList(sysUsers);
        pageResult.setTotal(sysUserDao.queryPageCount(userRequest));
        return pageResult;
    }

    /**
     * 根据用户名获取用户对象
     *
     * @param username
     * @return
     */
    @Override
    @Cacheable(cacheNames = AdminConstants.SYS_USERS_CACHE, key = "#username")
    public SysUser getUserByName(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return sysUserMapper.getUserByName(username);
    }

    /**
     * 修改密码
     *
     * @param username        用户名
     * @param oldpassword     旧密码
     * @param newpassword     新密码
     * @param confirmpassword 确认新密码
     * @return
     */
    @Override
    @CacheEvict(value = {AdminConstants.SYS_USERS_CACHE}, allEntries = true)
    public Result<?> resetPassword(String username, String oldpassword, String newpassword, String confirmpassword) {
        SysUser user = sysUserMapper.getUserByName(username);
        String passwordEncode = PasswordUtil.getPasswordEncode(oldpassword);
        if (!user.getPassword().equals(passwordEncode)) {
            return Result.error("旧密码输入错误!");
        }
        if (StringUtils.isEmpty(newpassword)) {
            return Result.error("新密码不允许为空!");
        }
        if (!newpassword.equals(confirmpassword)) {
            return Result.error("两次输入密码不一致!");
        }
        String password = PasswordUtil.getPasswordEncode(newpassword);
        SysUser sysUser = new SysUser();
        sysUser.setPassword(password);
        this.sysUserMapper.update(sysUser, new LambdaQueryWrapper<SysUser>().eq(SysUser::getId, user.getUuid()));
        return Result.success("密码重置成功!");
    }

    /**
     * 修改密码
     *
     * @param sysUser
     * @return
     */
    @Override
    @CacheEvict(value = {AdminConstants.SYS_USERS_CACHE}, allEntries = true)
    public Result<?> changePassword(SysUser sysUser) {
        String password = sysUser.getPassword();
        String passwordEncode = PasswordUtil.getPasswordEncode(password);
        sysUser.setPassword(passwordEncode);
        this.sysUserMapper.updateById(sysUser);
        return Result.success("密码修改成功!");
    }

    @Override
    public SysUser getUserByPhone(String phone) {
        return sysUserMapper.getUserByPhone(phone);
    }


    @Override
    public SysUser getUserByEmail(String mail) {
        return sysUserMapper.getUserByEmail(mail);
    }


    /**
     * 校验用户是否有效
     *
     * @param sysUser
     * @return
     */
    @Override
    public Result<?> checkUserIsEffective(SysUser sysUser) {
        Result<?> result = new Result<Object>();
        //情况1：根据用户信息查询，该用户不存在
        if (sysUser == null) {
            addLog("用户登录失败，用户不存在！", CommonConstant.LOG_TYPE_LOGIN, null);
            result.error500("该用户不存在，请注册");
            return result;
        }
        //情况2：根据用户信息查询，该用户已停用
        if (sysUser.getDeleted()) {
            addLog("用户登录失败，用户名:" + sysUser.getUsername() + "已停用！", CommonConstant.LOG_TYPE_LOGIN, null);
            result.error500("该用户已停用");
            return result;
        }
        return result;
    }

    /**
     * 用户信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public JSONObject userInfo(SysUser sysUser) {
        // 获取用户部门信息
        JSONObject obj = new JSONObject();
        List<SysDept> departs = sysDeptService.queryUserDeparts(sysUser.getUuid());
        List<SysRole> roles = sysRoleService.getRolesByUsername(sysUser.getUsername());
        String token = ssoServiceFeign.login(new SsoLoginRequest(sysUser.getUuid(), sysUser.getUsername(), sysUser.getPassword()));
        obj.put("departs", departs);
        obj.put("roles", roles);
        obj.put("token", token);
        obj.put("userInfo", sysUser);

        redisUtil.set(RedisKey.LOGIN_TOKEN+":"+token, sysUser);
        // 添加日志
        addLog("用户名: " + sysUser.getUsername() + ",登录成功！", CommonConstant.LOG_TYPE_LOGIN, null);
        return obj;
    }

    @Override
    public boolean register(RegisRequest regisRequest) {
        try {
            UserAddRequest sysUser = new UserAddRequest();
            sysUser.setUsername(regisRequest.getUsername());
            sysUser.setRealName(regisRequest.getUsername());
            sysUser.setNickname(regisRequest.getUsername());
            sysUser.setPassword(PasswordUtil.getPasswordEncode(regisRequest.getPassword()));
            sysUser.setMail(regisRequest.getMail());
            sysUser.setPhone(regisRequest.getPhone());
            return add(sysUser) > 0;
        } catch (Exception e) {
            log.error("注册异常", e);
        }
        return false;
    }

    @Override
    public boolean logout(String token) {
        SysUser sysUser = (SysUser) redisUtil.get(RedisKey.LOGIN_TOKEN + ":" + token);
        if (sysUser == null) {
            return true;
        }
        Result<Boolean> result = ssoServiceFeign.logout(new SsoLogoutRequest(token, sysUser.getUsername()));
        if (result.isSuccess()) {
            redisUtil.del(RedisKey.LOGIN_TOKEN + ":" + token);
            return result.getResult();
        }
        return false;
    }

    @Override
    public String qwUserImport() {
        Result<List<QwUserVo>> qwUsers = weixinApiFeign.getWxUsers();
        if (CommonConstant.SC_OK_200.equals(qwUsers.getCode()) && !CollectionUtils.isEmpty(qwUsers.getResult())){
            // 企微用户导入后默认密码为 wanli123
            qwUsers.getResult().forEach(u -> saveOrUpdate(SysUser.convertByWxUser(u)));
        }
        return Result.success().getMessage();
    }

    @Override
    public SysUserDeptAndRoleInfo deptAndRoleInfo(UserRequest userRequest) {
        Assert.notNull(userRequest.getUserUuid(),"用户uuid不能为空");
        SysUser sysUser = sysUserDao.queryByUuid(userRequest.getUserUuid());
        if (null != sysUser){
            List<SysRole> roles = sysRoleService.queryUserRoles(userRequest.getUserUuid());
            List<SysDept> depts = sysDeptService.queryUserDeparts(userRequest.getUserUuid());

            SysUserDeptAndRoleInfo sysUserDeptAndRoleInfo = new SysUserDeptAndRoleInfo();
            sysUserDeptAndRoleInfo.setUserUuid(sysUser.getUuid());
            sysUserDeptAndRoleInfo.setUserName(sysUser.getRealName());
            sysUserDeptAndRoleInfo.setRoleResponseList(roles.stream().map(SysRoleResponse::convertByEntity).toList());
            sysUserDeptAndRoleInfo.setDeptResponseList(depts.stream().map(SysDeptResponse::convertByEntity).toList());

            return  sysUserDeptAndRoleInfo;
        }
        return null;
    }
}