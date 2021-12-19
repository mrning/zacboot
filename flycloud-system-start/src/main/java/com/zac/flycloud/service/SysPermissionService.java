package com.zac.flycloud.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zac.flycloud.bean.tablemodel.SysPermission;

import java.util.List;

public interface SysPermissionService extends SysBaseService<SysPermission> {

    void getPermissionJsonArray(JSONArray jsonArray, List<SysPermission> sysPermissions, JSONObject parentJson);

    JSONObject getPermissionJsonObject(SysPermission permission);

    boolean hasIndexPage(List<SysPermission> metaList);
}