package com.zac.flycloud.base;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zac.flycloud.utils.UrlIPUtils;
import com.zac.flycloud.utils.SpringContextUtils;
import com.zac.flycloud.constant.CacheConstant;
import com.zac.flycloud.entity.tablemodel.SysDept;
import com.zac.flycloud.entity.tablemodel.SysLog;
import com.zac.flycloud.entity.tablemodel.SysRole;
import com.zac.flycloud.entity.tablemodel.SysUser;
import com.zac.flycloud.mapper.*;
import com.zac.flycloud.sys.SysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 底层共通业务API，提供其他独立模块调用
 * @Author: scott
 * @Date:2019-4-20
 * @Version:V1.0
 */
@Slf4j
@Service
public class SysBaseApiImpl implements SysBaseAPI {

    @Resource
    private SysLogMapper sysLogMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysDeptService sysDepartService;
    @Resource
    private SysRoleMapper roleMapper;
    @Resource
    private SysDeptMapper departMapper;

    /**
     * 添加日志
     *
     * @param LogContent  内容
     * @param logType     日志类型(0:操作日志;1:登录日志;2:定时任务)
     * @param operatetype 操作类型(1:添加;2:修改;3:删除;)
     */
    @Override
    public void addLog(String LogContent, Integer logType, Integer operatetype) {
        SysLog sysLog = new SysLog();
        //注解上的描述,操作日志内容
        sysLog.setLogContent(LogContent);
        sysLog.setLogType(logType);
        sysLog.setOperateType(operatetype);

        //请求的方法名
        //请求的参数

        try {
            //获取request
            HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
            //设置IP地址
            sysLog.setIp(UrlIPUtils.getIpAddr(request));
        } catch (Exception e) {
            sysLog.setIp("127.0.0.1");
        }

        //获取登录用户信息
        if(null == SecurityContextHolder.getContext().getAuthentication()){
            sysLog.setUserid(null);
            sysLog.setUsername(null);
        }else{
            User securityUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SysUser sysUser = getUserByName(securityUser.getUsername());
            if (securityUser != null) {
                sysLog.setUserid(String.valueOf(sysUser.getId()));
                sysLog.setUsername(sysUser.getRealname());
            }
        }
        sysLog.setCreateTime(new Date());
        sysLog.setUuid(UUID.randomUUID().toString());
        //保存系统日志
        sysLogMapper.insert(sysLog);
    }

    /**
     * 根据用户名获取用户对象
     *
     * @param username
     * @return
     */
    @Override
    @Cacheable(cacheNames = CacheConstant.SYS_USERS_CACHE, key = "#username")
    public SysUser getUserByName(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        SysUser loginUser = new SysUser();
        SysUser sysUser = sysUserMapper.getUserByName(username);
        if (sysUser == null) {
            return null;
        }
        BeanUtils.copyProperties(sysUser, loginUser);
        return loginUser;
    }

    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public SysUser getUserById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        SysUser loginUser = new SysUser();
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            return null;
        }
        BeanUtils.copyProperties(sysUser, loginUser);
        return loginUser;
    }

    @Override
    public List<String> getRolesByUsername(String username) {
        return sysUserRoleMapper.getRoleByUserName(username);
    }

    @Override
    public List<String> getDepartNamesByUsername(String username) {
        List<SysDept> list = sysDepartService.queryDepartsByUsername(username);
        List<String> result = new ArrayList<>(list.size());
        for (SysDept depart : list) {
            result.add(depart.getDepartName());
        }
        return result;
    }


    @Override
    public List<JSONObject> queryAllDepart(Wrapper wrapper) {
        return JSON.parseArray(JSON.toJSONString(sysDepartService.list(wrapper))).toJavaList(JSONObject.class);
    }

    @Override
    public List<JSONObject> queryAllUser(Wrapper wrapper) {
        return JSON.parseArray(JSON.toJSONString(sysUserMapper.selectList(wrapper))).toJavaList(JSONObject.class);
    }

    @Override
    public List<SysRole> queryAllRole() {
        return roleMapper.selectList(new QueryWrapper<SysRole>());
    }

    @Override
    public List<SysRole> queryAllRole(String[] roleIds) {
        List<SysRole> list = new ArrayList<>();
        List<SysRole> roleList = roleMapper.selectList(new QueryWrapper<SysRole>());
        for (SysRole role : roleList) {
            if (null != roleIds && roleIds.length > 0) {
                for (int i = 0; i < roleIds.length; i++) {
                    if (roleIds[i].equals(role.getId())) {
                        list.add(role);
                    }
                }
            }

        }
        return list;
    }

    @Override
    public List<String> getRoleIdsByUsername(String username) {
        return sysUserRoleMapper.getRoleIdByUserName(username);
    }

    @Override
    public String getDepartIdsByOrgCode(String orgCode) {
        return departMapper.queryDepartIdByOrgCode(orgCode);
    }

    @Override
    public SysDept getParentDepartId(String departId) {
        return departMapper.getParentDepartId(departId);
    }

    @Override
    public List<SysDept> getAllSysDept() {
        return departMapper.selectList(new QueryWrapper<SysDept>().eq("del_flag", "0"));
    }

    @Override
    public List<String> getDeptHeadByDepId(String deptId) {
        List<SysUser> userList = sysUserMapper.selectList(new QueryWrapper<SysUser>().like("depart_ids", deptId).eq("status", 1).eq("del_flag", 0));
        List<String> list = new ArrayList<>();
        for (SysUser user : userList) {
            list.add(user.getUsername());
        }
        return list;
    }
}