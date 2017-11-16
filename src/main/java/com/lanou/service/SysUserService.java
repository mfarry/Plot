package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public interface SysUserService {


    // 登录
    User selectlognameandpwd(String username);

    List<User> findAll();

    //分页
    PageInfo<User> getPageInfo(Integer pageNo, Integer pageSize);

    //添加
    Integer insert(User record);

    //根据id删除
    Integer deletByUserId(Integer id);

    //修改密码
    Integer updatePwd(User record);

    //根据id查找
    User findById(Integer id);

    User selectByPrimaryKey(Integer id);

    // 搜索
    List<User> findByDate(String creatime,String endtime,String name);





}
