package com.lanou.mapper;

import com.lanou.bean.SysRole;

import java.util.List;

public interface SysRoleMapper {

    // 根据id删除
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKeyWithBLOBs(SysRole record);

    int updateByPrimaryKey(SysRole record);


    List<SysRole>getRolesAll();
}