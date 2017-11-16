package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;
import com.lanou.bean.SysRole;
import com.lanou.mapper.SysMenuMapper;
import com.lanou.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getMenuAll() {
        return sysMenuMapper.getMenuAll();
    }

    @Override
    public SysMenu selectByPrimaryKey(Integer id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<SysMenu> getPageinfo(Integer pageNo, Integer pageSize) {
        return queryCost(pageNo,pageSize);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteAllMenu(Integer id) {
        return sysMenuMapper.deleteAllMenu(id);
    }

    @Override
    public List<SysMenu> searchMenu(SysMenu record) {
        return sysMenuMapper.searchMenu(record);
    }

    public PageInfo<SysMenu> queryCost(Integer pageNo, Integer pageSize){



        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<SysMenu>sysMenus=sysMenuMapper.getMenuAll();


//        使用PageInfo对结果进行包装
        PageInfo<SysMenu> pageInfo=new PageInfo<>(sysMenus);



        return pageInfo;
    }

}
