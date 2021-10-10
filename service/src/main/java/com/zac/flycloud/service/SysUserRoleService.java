package com.zac.flycloud.service;

import com.zac.flycloud.basebean.PageResult;
import com.zac.flycloud.base.SysBaseService;
import com.zac.flycloud.dto.SysUserRoleDTO;
import com.zac.flycloud.tablemodel.SysUserRole;
import com.zac.flycloud.vos.UserRoleRequestVO;

/**
 * AutoCreateFile
 * @date 2021年4月30日星期五
 * @author zac
 */
public interface SysUserRoleService extends SysBaseService<SysUserRole> {
    Integer add(SysUserRoleDTO sysUserRoleDTO);

    Integer del(SysUserRoleDTO sysUserRoleDTO);

    Integer update(SysUserRoleDTO sysUserRoleDTO);

    PageResult<SysUserRoleDTO> queryPage(UserRoleRequestVO userRoleRequestVO);
}