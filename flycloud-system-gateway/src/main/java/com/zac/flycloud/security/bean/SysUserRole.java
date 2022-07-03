package com.zac.flycloud.security.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zac.flycloud.common.basebeans.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @Author scott
 * @since 2018-12-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    /**
     * 用户id
     */
    private String userUuid;

    /**
     * 角色id
     */
    private String roleUuid;


}
