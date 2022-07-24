package com.zacboot.admin.controller;

import com.zacboot.admin.beans.entity.SysRole;
import com.zacboot.admin.beans.vos.request.RoleRequest;
import com.zacboot.admin.service.SysRoleService;
import com.zacboot.common.base.basebeans.PageResult;
import com.zacboot.common.base.basebeans.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AutoCreateFile 角色管理 
 * @date 2021年4月30日星期五
 * @author zac
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/sysRole")
@Slf4j
public class AdminSysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * AutoCreateFile add
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/add")
    @ApiOperation("新增")
    public Result<Integer> add(@RequestBody SysRole sysRole) {
        return Result.success(sysRoleService.add(sysRole));
    }

    /**
     * AutoCreateFile del
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/del")
    @ApiOperation("删除")
    public Result<Integer> del(@RequestBody SysRole sysRole) {
        return Result.success(sysRoleService.del(sysRole));
    }

    /**
     * AutoCreateFile update
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/update")
    @ApiOperation("更新")
    public Result<Integer> update(@RequestBody SysRole sysRole) {
        return Result.success(sysRoleService.update(sysRole));
    }

    /**
     * AutoCreateFile queryPage
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/queryPage")
    @ApiOperation("分页查询")
    public Result<PageResult<SysRole>> queryPage(@RequestBody RoleRequest roleRequest) {
        return Result.success(sysRoleService.queryPage(roleRequest));
    }

    /**
     * 查询全部角色
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/queryAll")
    @ApiOperation("查询全部")
    public Result<List<SysRole>> queryAll() {
        return Result.success(sysRoleService.queryAll());
    }

    @GetMapping("/queryByUserUuid")
    @ApiOperation("根据用户uuid查询用户角色列表")
    public Result<List<SysRole>> queryByUserUuid(@RequestParam String userUuid){
        return Result.success(sysRoleService.queryUserRoles(userUuid));
    }
}