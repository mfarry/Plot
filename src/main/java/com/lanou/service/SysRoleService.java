package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysRole;
import com.lanou.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface SysRoleService {
    List<SysRole> getRolesAll();

    PageInfo<SysRole> getPageinfo(Integer pageNo, Integer pageSize);

    int delAllRole(Integer id);
    // 根据id删除
     Integer deleteByRoleId(Integer id);
}
