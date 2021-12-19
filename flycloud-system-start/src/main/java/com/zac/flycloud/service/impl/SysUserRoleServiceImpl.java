package com.zac.flycloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Page;
import com.zac.flycloud.bean.basebean.PageResult;
import com.zac.flycloud.service.impl.SysBaseServiceImpl;
import com.zac.flycloud.dao.SysUserRoleDao;
import com.zac.flycloud.bean.dto.SysUserRoleDTO;
import com.zac.flycloud.dao.mapper.SysUserRoleMapper;
import com.zac.flycloud.service.SysUserRoleService;
import com.zac.flycloud.bean.tablemodel.SysUserRole;
import com.zac.flycloud.bean.vos.UserRoleRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * AutoCreateFile
 * @date 2021年4月30日星期五
 * @author zac
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends SysBaseServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    public Integer add(SysUserRoleDTO sysUserRoleDTO) {
        return sysUserRoleDao.add(sysUserRoleDTO);
    }

    public Integer del(SysUserRoleDTO sysUserRoleDTO) {
        Assert.isTrue(BeanUtil.isEmpty(sysUserRoleDTO),"不能全部属性为空，会删除全表数据");
        return sysUserRoleDao.del(sysUserRoleDTO);
    }

    public Integer update(SysUserRoleDTO sysUserRoleDTO) {
        return sysUserRoleDao.update(sysUserRoleDTO);
    }

    public PageResult<SysUserRoleDTO> queryPage(UserRoleRequestVO userRoleRequestVO) {
        PageResult<SysUserRoleDTO> pageResult = new PageResult<>();
        pageResult.setDataList(sysUserRoleDao.queryPage(userRoleRequestVO,new Page(userRoleRequestVO.getPageNumber(),userRoleRequestVO.getPageSize())));
        pageResult.setTotal(sysUserRoleDao.queryPageCount(userRoleRequestVO).intValue());
        return pageResult;
    }
}