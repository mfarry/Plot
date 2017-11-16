package com.lanou.mapper;

import com.lanou.bean.SysMenu;
import com.lanou.bean.User;
import org.apache.ibatis.annotations.Param;

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

    // 搜索
    List<SysMenu> findByMenu(@Param("startime") String startime,
                          @Param("endtime") String endtime,
                          @Param("name") String name);
}