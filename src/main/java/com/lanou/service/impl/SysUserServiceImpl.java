package com.lanou.service.impl;

import com.lanou.bean.User;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
@Service
public class SysUserServiceImpl implements SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public User selectlognameandpwd(String username) {
        return sysUserMapper.selectlognameandpwd(username);
    }


    @Override
    public List<User> findalladmin() {
        return sysUserMapper.findAlladmin();
    }
}
