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


}
