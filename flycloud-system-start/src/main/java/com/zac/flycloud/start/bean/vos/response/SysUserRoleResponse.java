package com.zac.flycloud.start.bean.vos.response;

import com.zac.flycloud.start.bean.entity.SysRole;
import com.zac.flycloud.start.bean.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SysUserRoleResponse {

    private String userUuid;
    private String userName;
    private String userRealName;
    private String roleUuid;
    private String roleName;

    public SysUserRoleResponse(SysUser sysUser, SysRole sysRole){
        this.setUserUuid(sysUser.getUuid());
        this.setUserName(sysUser.getUsername());
        this.setUserRealName(sysUser.getRealname());
        this.setRoleUuid(sysRole.getUuid());
        this.setRoleName(sysRole.getRoleName());
    }
}
