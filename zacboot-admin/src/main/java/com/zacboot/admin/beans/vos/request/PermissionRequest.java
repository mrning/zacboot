package com.zacboot.admin.beans.vos.request;

import cn.hutool.db.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author zac
 * @since 2022-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysPermission对象", description = "权限表")
public class PermissionRequest extends Page implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "菜单/权限编码")
    private String code;

    @ApiModelProperty(value = "菜单类型0=父级菜单1=子菜单2=权限按钮")
    private Integer menuType;

}
