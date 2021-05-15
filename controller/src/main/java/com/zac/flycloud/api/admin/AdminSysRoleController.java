package com.zac.flycloud.api.admin;

import cn.hutool.db.PageResult;
import com.zac.flycloud.BaseController;
import com.zac.flycloud.basebean.DataResponseResult;
import com.zac.flycloud.dto.SysRoleDTO;
import com.zac.flycloud.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * AutoCreateFile 角色管理 
 * @date 2021年4月30日星期五
 * @author zac
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/api/admin/sysRole")
@Slf4j
public class AdminSysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * AutoCreateFile add
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/add")
    @ApiOperation("新增")
    public DataResponseResult<Integer> add(@RequestBody SysRoleDTO sysRoleDTO) {
        return DataResponseResult.success(sysRoleService.add(sysRoleDTO));
    }

    /**
     * AutoCreateFile del
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/del")
    @ApiOperation("删除")
    public DataResponseResult<Integer> del(@RequestBody SysRoleDTO sysRoleDTO) {
        return DataResponseResult.success(sysRoleService.del(sysRoleDTO));
    }

    /**
     * AutoCreateFile update
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/update")
    @ApiOperation("更新")
    public DataResponseResult<Integer> update(@RequestBody SysRoleDTO sysRoleDTO) {
        return DataResponseResult.success(sysRoleService.update(sysRoleDTO));
    }

    /**
     * AutoCreateFile queryPage
     * @date 2021年4月30日星期五
     * @author zac
     */
    @PostMapping("/queryPage")
    @ApiOperation("分页查询")
    public DataResponseResult<PageResult<SysRoleDTO>> queryPage(@RequestBody SysRoleDTO sysRoleDTO) {
        return DataResponseResult.success(sysRoleService.queryPage(sysRoleDTO));
    }
}