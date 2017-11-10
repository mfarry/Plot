package com.lanou.service;

import com.lanou.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public interface SysUserService {

    // 登录
    User selectlognameandpwd(String username);

    // 显示全部admin
    List<User> findalladmin();
}
