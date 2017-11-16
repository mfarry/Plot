package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;
import com.lanou.bean.SysRole;
import org.apache.ibatis.annotations.Param;

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

    List<SysMenu> findByMenu(@Param("startime") String startime,
                             @Param("endtime") String endtime,
                             @Param("name") String name);
}
