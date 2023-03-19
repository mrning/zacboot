package com.zacboot.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Page;
import com.zac.system.core.entity.admin.SysUserDept;
import com.zacboot.admin.beans.vos.request.UserDeptRequest;
import com.zacboot.admin.dao.SysUserDeptDao;
import com.zacboot.admin.mapper.SysUserDeptMapper;
import com.zacboot.admin.service.SysUserDeptService;
import com.zacboot.common.base.basebeans.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * AutoCreateFile
 * @date 2021年4月30日星期五
 * @author zac
 */
@Slf4j
@Service
public class SysUserDeptServiceImpl extends SysBaseServiceImpl<SysUserDeptMapper, SysUserDept> implements SysUserDeptService {
    @Autowired
    private SysUserDeptDao sysUserDeptDao;

    public Integer add(SysUserDept sysUserDept) {
        return sysUserDeptDao.add(sysUserDept);
    }

    public Integer del(SysUserDept sysUserDept) {
        Assert.isTrue(BeanUtil.isEmpty(sysUserDept),"不能全部属性为空，会删除全表数据");
        return sysUserDeptDao.del(sysUserDept);
    }

    public Integer update(SysUserDept sysUserDept) {
        return sysUserDeptDao.update(sysUserDept);
    }

    public PageResult<SysUserDept> queryPage(UserDeptRequest userDeptRequest) {
        PageResult<SysUserDept> pageResult = new PageResult<>();
        pageResult.setDataList(sysUserDeptDao.queryPage(userDeptRequest, new Page(userDeptRequest.getPageNumber(), userDeptRequest.getPageSize())));
        pageResult.setTotal(sysUserDeptDao.queryPageCount(userDeptRequest).intValue());
        return pageResult;
    }

    @Override
    public Integer delByUserUuid(String userUuid) {
        return sysUserDeptDao.delByUserUuid(userUuid);
    }
}