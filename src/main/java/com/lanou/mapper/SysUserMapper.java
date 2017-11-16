package com.lanou.mapper;

import com.lanou.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    //根据id删除
    int deleteByPrimaryKey(Integer id);

//    添加
    Integer insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 登录
    User selectlognameandpwd(String username);


    //显示全部
    List<User> findAll();

    //修改密码
    Integer updatePwd(User record);

    // 搜索
    List<User> findByDate(@Param("startime") String startime,
                          @Param("endtime") String endtime,
                          @Param("username") String username);
}