package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;
import com.lanou.bean.SysRole;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface SysMenuService {
    List<SysMenu> getMenuAll();

    SysMenu selectByPrimaryKey(Integer id);

    PageInfo<SysMenu> getPageinfo(Integer pageNo, Integer pageSize);


    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    int deleteAllMenu(Integer id);
}
