package com.zac.flycloud.dao.impl;

import com.zac.flycloud.dao.UserDao;
import com.zac.flycloud.mapper.SysUserMapper;
import com.zac.flycloud.entity.tablemodel.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByName(String username) {
        return sysUserMapper.getUserByName(username);
    }
}
