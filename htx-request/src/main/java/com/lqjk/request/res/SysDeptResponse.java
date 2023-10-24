package com.lqjk.request.res;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lqjk.base.bizentity.SysDept;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class SysDeptResponse {

    private String uuid;

    /**
     * 父机构ID
     */
    private String parentUuid;
    /**
     * 上级部门名称
     */
    private String parentName;
    /**
     * 机构/部门名称
     */
    private String departName;
    /**
     * 描述
     */
    private String description;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 部门领导id
     */
    private String leaderUuid;
    /**
     * 部门领导名称
     */
    private String leaderName;
    /**
     * 地址
     */
    private String deptAddress;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public SysDeptResponse convertByEntity(SysDept sysDept){
        if (null == sysDept){
            return null;
        }
        BeanUtil.copyProperties(sysDept,this);
        return this;
    }
}