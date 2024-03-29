package com.zacboot.system.core.request.sso;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SsoLoginRequest {
    @NotEmpty
    @ApiModelProperty(value = "用户id",required = true)
    private String userUuid;
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
