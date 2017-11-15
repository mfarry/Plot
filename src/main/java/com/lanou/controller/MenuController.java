package com.lanou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;
import com.lanou.bean.SysRole;
import com.lanou.service.SysMenuService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class MenuController {

    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/menuall")
    public String menuAll() {
        return "menu-list";
    }

    @RequestMapping(value = "/menuadd")
    public String menuAdd(){
        return "menu-add";
    }

    @ResponseBody
    @RequestMapping(value = "/getmenuall")
    public AjaxResult getMenuAll1() {
        System.out.println(12);
        List<SysMenu> menuAll = sysMenuService.getMenuAll();


        System.out.println(menuAll);
        return new AjaxResult(menuAll);
    }

    @ResponseBody
    @RequestMapping(value = "/pageinfoMenu")
    public PageInfo<SysMenu> pageInfo(@RequestParam("pageNo") Integer pageNo , @RequestParam("pagesize") Integer pageSize){


        return sysMenuService.getPageinfo(pageNo,pageSize);
    }


    @ResponseBody
@RequestMapping(value = "/delMenu")
    public AjaxResult delMenu(Integer id){
    int key = sysMenuService.deleteByPrimaryKey(id);
    return new AjaxResult(key);


}

@ResponseBody
@RequestMapping(value = "/getMenuById")
public AjaxResult getMenuById(HttpServletRequest request, HttpServletResponse response,Integer id){
    SysMenu sysMenu = sysMenuService.selectByPrimaryKey(id);
    System.out.println(sysMenu);
    request.getSession().setAttribute("menuAll",sysMenu);
    return new AjaxResult(sysMenu);
}

@ResponseBody
@RequestMapping(value = "/getMenuList")
public AjaxResult getMenuList(HttpServletRequest request, HttpServletResponse response){
    SysMenu menuAll = (SysMenu) request.getSession().getAttribute("menuAll");

    return new AjaxResult(menuAll);
}

@ResponseBody
@RequestMapping(value = "/insertMenu")
public AjaxResult insertMenu(SysMenu record){
    int i = sysMenuService.insert(record);
    return new AjaxResult(i);
}
}
