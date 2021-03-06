package com.zac.flycloud.service;

import com.zac.flycloud.bean.basebean.PageResult;
import com.zac.flycloud.bean.dto.SysRole;
import com.zac.flycloud.bean.vos.request.RoleRequest;

import java.util.List;

/**
 * AutoCreateFile
 * @date 2021年4月30日星期五
 * @author zac
 */
public interface SysRoleService extends SysBaseService<SysRole> {
    Integer add(SysRole sysRole);

    Integer del(SysRole sysRole);

    Integer update(SysRole sysRole);

    PageResult<SysRole> queryPage(RoleRequest roleRequest);

    List<SysRole> queryAll();

    List<SysRole> queryUserRoles(String userUuid);

}