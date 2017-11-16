package com.lanou.mapper;

import com.lanou.bean.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getMenuAll();

    int deleteAllMenu(Integer id);

List<SysMenu> searchMenu(SysMenu record);
}