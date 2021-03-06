package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysRole;
import com.lanou.service.SysRoleService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller
public class RoleController {

    @Resource
    private SysRoleService sysRoleService;

    //    跳转到用户角色列表
    @RequestMapping(value = "/roles")
    public String roles() {
        return "admin-role";
    }


    //    获得全部角色
    @ResponseBody
    @RequestMapping(value = "/getRolesAll")
    public AjaxResult getRolesAll() {

        List<SysRole> sysRoles = sysRoleService.getRolesAll();
        System.out.println(sysRoles);
        return new AjaxResult(sysRoles);
    }


    @ResponseBody
    @RequestMapping(value = "/pageinfo")
    public PageInfo<SysRole> pageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize) {


        return sysRoleService.getPageinfo(pageNo, pageSize);
    }


//    // 删除 
//    @ResponseBody 
//    @RequestMapping(value = "/deleteRole") 
//    public AjaxResult deleteRole(Integer id) { 
//        Integer reid = sysRoleService.deleteByRoleId(id); 
//        System.out.println(reid); 
//        return new AjaxResult(reid);
//         }

    // 删除
    @ResponseBody
    @RequestMapping(value = "/deleteRole")
    public AjaxResult deleteRole(Integer id){
        Integer reid = sysRoleService.deleteByRoleId(id);
        return new AjaxResult(reid);
    }


    @ResponseBody
    @RequestMapping(value = "/delAllRole")
    public AjaxResult delAllRole(@RequestParam("id") String mle){

        String[] id = mle.split(",");
        for (int i = 0; i < id.length; i++) {
            int i1 = sysRoleService.delAllRole(Integer.parseInt(id[i]));

        }

        return new AjaxResult(0);
    }


}
