package com.zacboot.admin.beans.vos.request;

import cn.hutool.db.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRoleRequest extends Page {

    @ApiModelProperty("角色uuid")
    private String roleUuid;
}
