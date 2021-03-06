package com.zac.flycloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Page;
import com.zac.flycloud.bean.basebean.PageResult;
import com.zac.flycloud.bean.dto.SysUserDept;
import com.zac.flycloud.bean.vos.request.UserDeptRequest;
import com.zac.flycloud.dao.SysUserDeptDao;
import com.zac.flycloud.dao.mapper.SysUserDeptMapper;
import com.zac.flycloud.service.SysUserDeptService;
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
        pageResult.setDataList(sysUserDeptDao.queryPage(userDeptRequest,new Page(userDeptRequest.getPageNumber(), userDeptRequest.getPageSize())));
        pageResult.setTotal(sysUserDeptDao.queryPageCount(userDeptRequest).intValue());
        return pageResult;
    }
}