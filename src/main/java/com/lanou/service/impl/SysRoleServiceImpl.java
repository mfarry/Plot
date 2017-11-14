package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysRole;
import com.lanou.bean.User;
import com.lanou.mapper.SysRoleMapper;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
@Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserMapper sysUserMapper;


    @Override
    public List<SysRole> getRolesAll() {
        return sysRoleMapper.getRolesAll();
    }

    @Override
    public PageInfo<SysRole> getPageinfo(Integer pageNo, Integer pageSize) {
        return queryCost(pageNo,pageSize);
    }

    @Override
    public Integer deleteByRoleId(Integer id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    public PageInfo<SysRole> queryCost(Integer pageNo, Integer pageSize){



        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<SysRole>sysRoles=sysRoleMapper.getRolesAll();
        System.out.println(sysRoles+"::");

//        使用PageInfo对结果进行包装
        PageInfo<SysRole> pageInfo=new PageInfo<>(sysRoles);



        return pageInfo;
    }
}
