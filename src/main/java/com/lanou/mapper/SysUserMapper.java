package com.lanou.mapper;

import com.lanou.bean.User;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 登录
    User selectlognameandpwd(String username);

    //查看全部(管理员)
    List<User> findAlladmin();
}