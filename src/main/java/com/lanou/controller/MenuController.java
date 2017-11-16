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
    public String menuAdd() {
        return "menu-add";
    }

    @RequestMapping(value = "/menumodi")
    public String menumodi() {
        return "menu-modi";
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
    public PageInfo<SysMenu> pageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize) {


        return sysMenuService.getPageinfo(pageNo, pageSize);
    }


    @ResponseBody
    @RequestMapping(value = "/delMenu")
    public AjaxResult delMenu(Integer id) {
        int key = sysMenuService.deleteByPrimaryKey(id);
        return new AjaxResult(key);


    }

    @ResponseBody
    @RequestMapping(value = "/getAllmenuById")
    public AjaxResult getAllmenuById(HttpServletRequest request, HttpServletResponse response, Integer id) {
        SysMenu sysMenu = sysMenuService.selectByPrimaryKey(id);
        request.getSession().setAttribute("menuAll", sysMenu);
        return new AjaxResult(sysMenu);
    }

    @ResponseBody
    @RequestMapping(value = "/getMenuList")
    public AjaxResult getMenuList(HttpServletRequest request, HttpServletResponse response) {
        SysMenu menuAll = (SysMenu) request.getSession().getAttribute("menuAll");

        return new AjaxResult(menuAll);
    }

    @ResponseBody
    @RequestMapping(value = "/insertMenu")
    public AjaxResult insertMenu(SysMenu record) {
        int i = sysMenuService.insert(record);
        return new AjaxResult(i);
    }


    @ResponseBody
    @RequestMapping(value = "/updateMenu")
    public AjaxResult updateMenu(SysMenu record) {
        int i = sysMenuService.updateByPrimaryKey(record);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAllMenu")
    public AjaxResult deleteAllMenu(@RequestParam("id") String mle){

        String[] id = mle.split(",");
        for (int i = 0; i < id.length; i++) {
            int i1 = sysMenuService.deleteAllMenu(Integer.parseInt(id[i]));

        }

        return new AjaxResult(0);
    }

    @ResponseBody
    @RequestMapping(value = "/findByMenu")
    public AjaxResult findByMenu(@RequestParam("startime") String startime,
                                 @RequestParam("endtime") String endtime,
                                 @RequestParam("name") String name){

        if (name.equals("")){
            name=null;
        }

        if (startime.equals("")){
           startime=null;
        }
        if (endtime.equals("")){
           endtime=null;
        }


        List<SysMenu> sysMenus = sysMenuService.findByMenu(name,startime,endtime);

        return new AjaxResult(sysMenus);


    }
}
