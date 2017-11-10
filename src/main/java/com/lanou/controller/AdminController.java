package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysRole;
import com.lanou.bean.User;
import com.lanou.service.SysRoleService;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller
public class AdminController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/admin")
    public String admin(){return "admin-list";}

    @RequestMapping(value = "/adminadd")
    public String adminAdd(){return "admin-add";}



    //分页
    @ResponseBody
    @RequestMapping(value = "/pageinfoAdmin")
    public PageInfo<User> pageInfo(@RequestParam("pageNo")Integer pageNo, @RequestParam("pagesize") Integer pageSize){

        return sysUserService.getPageInfo(pageNo,pageSize);
    }



    //找到角色姓名
    @ResponseBody
    @RequestMapping(value = "/getRoleName")
    public AjaxResult getRoleName(){
        List<SysRole> all = sysRoleService.getRolesAll();

        return new AjaxResult(all);
    }

    //添加
    @ResponseBody
    @RequestMapping(value = "/adminaddall")
    public AjaxResult adminAdd(User sysUser){
        sysUser.setState(1);
        sysUser.setCreateTime(new Date());
        Integer insert = sysUserService.insert(sysUser);
        return new AjaxResult(insert);
    }

    //根据id删除
    @ResponseBody
    @RequestMapping(value = "/admindelete")
    public AjaxResult adminDelete(Integer id){
        Integer integer = sysUserService.deletByUserId(id);
        return new AjaxResult(integer);

    }

}
