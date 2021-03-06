package com.zac.flycloud.dao.impl;

import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zac.flycloud.bean.dto.SysDept;
import com.zac.flycloud.bean.dto.example.SysDeptExample;
import com.zac.flycloud.bean.vos.request.DeptRequest;
import com.zac.flycloud.dao.SysDeptDao;
import com.zac.flycloud.dao.mapper.SysDeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AutoCreateFile
 * @date 2021年4月30日星期五
 * @author zac
 */
@Repository
@Slf4j
public class SysDeptDaoImpl implements SysDeptDao {
    @Autowired
    private SysDeptMapper sysDeptMapper;

    public Integer add(SysDept sysDept) {
        return sysDeptMapper.insertSelective(sysDept);
    }

    public Integer del(SysDept sysDept) {
        SysDeptExample sysDeptExample = new SysDeptExample();
        return sysDeptMapper.deleteByExample(sysDeptExample);
    }

    public Integer update(SysDept sysDept) {
        SysDeptExample sysDeptExample = new SysDeptExample();
        return sysDeptMapper.updateByExampleSelective(sysDept, sysDeptExample);
    }

    public List<SysDept> queryPage(DeptRequest deptRequest, Page page) {
        SysDeptExample sysDeptExample = new SysDeptExample();
        return sysDeptMapper.selectByExampleWithRowbounds(sysDeptExample,new RowBounds(page.getPageNumber(),page.getPageSize()));
    }

    public Long queryPageCount(DeptRequest deptRequest) {
        SysDeptExample sysDeptExample = new SysDeptExample();
        return sysDeptMapper.countByExample(sysDeptExample);
    }

    @Override
    public List<SysDept> queryAll() {
        return sysDeptMapper.selectList(Wrappers.emptyWrapper());
    }
}