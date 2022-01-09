package com.zac.flycloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Page;
import com.zac.flycloud.bean.basebean.PageResult;
import com.zac.flycloud.bean.dto.SysRoleDTO;
import com.zac.flycloud.bean.tablemodel.SysRole;
import com.zac.flycloud.bean.vos.RoleRequestVO;
import com.zac.flycloud.dao.SysRoleDao;
import com.zac.flycloud.dao.mapper.SysRoleMapper;
import com.zac.flycloud.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * AutoCreateFile
 * @date 2021年4月30日星期五
 * @author zac
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends SysBaseServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    public Integer add(SysRoleDTO sysRoleDTO) {
        return sysRoleDao.add(sysRoleDTO);
    }

    public Integer del(SysRoleDTO sysRoleDTO) {
        Assert.isTrue(BeanUtil.isEmpty(sysRoleDTO),"不能全部属性为空，会删除全表数据");
        return sysRoleDao.del(sysRoleDTO);
    }

    public Integer update(SysRoleDTO sysRoleDTO) {
        return sysRoleDao.update(sysRoleDTO);
    }

    public PageResult<SysRoleDTO> queryPage(RoleRequestVO roleRequestVO) {
        PageResult<SysRoleDTO> pageResult = new PageResult<>();
        pageResult.setDataList(sysRoleDao.queryPage(roleRequestVO,new Page(roleRequestVO.getPageNumber(),roleRequestVO.getPageSize())));
        pageResult.setTotal(sysRoleDao.queryPageCount(roleRequestVO).intValue());
        return pageResult;
    }

    @Override
    public List<SysRoleDTO> queryAll() {
        return sysRoleDao.queryAll();
    }
}