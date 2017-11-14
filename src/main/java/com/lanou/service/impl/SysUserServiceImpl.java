package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    //显示全部
    @Override
    public List<User> findAll() {
        return sysUserMapper.findAll();
    }

    //添加
    @Override
    public Integer insert(User sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public Integer deletByUserId(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updatePwd(User record) {
        return sysUserMapper.updatePwd(record);
    }


    //分页
    @Override
    public PageInfo<User> getPageInfo(Integer pageNo, Integer pageSize) {
        return queryCostByPage(pageNo,pageSize);
    }

    public PageInfo<User> queryCostByPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);
        //获取全部的学员
        List<User> adminInfos = sysUserMapper.findAll();
//        System.out.println(adminInfos);

        //使用PageINfo对结果进行包装

        PageInfo<User> pageInfo = new PageInfo<User>(adminInfos);

        System.out.println(pageInfo);
        return pageInfo;
    }

}
