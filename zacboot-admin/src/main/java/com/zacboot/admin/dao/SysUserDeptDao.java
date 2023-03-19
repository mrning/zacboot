package com.zacboot.admin.dao;


import cn.hutool.db.Page;
import com.zac.system.core.entity.admin.SysDept;
import com.zac.system.core.entity.admin.SysUserDept;
import com.zacboot.admin.beans.vos.request.UserDeptRequest;

import java.util.List;

public interface SysUserDeptDao {

    List<SysDept> getDeptsByUserUuid(String userUuid);

    Integer add(SysUserDept sysUserDept);

    Integer del(SysUserDept sysUserDept);

    Integer update(SysUserDept sysUserDept);

    List<SysUserDept> queryPage(UserDeptRequest userDeptRequest, Page page);

    Long queryPageCount(UserDeptRequest userDeptRequest);

    Integer delByUserUuid(String userUuid);
}
