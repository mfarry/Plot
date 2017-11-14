package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysRole;
import com.lanou.bean.User;
import com.lanou.service.SysRoleService;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    @RequestMapping(value = "/changepwd")
    public String changePwd(){return "admin-password-edit";}

    @ResponseBody
    @RequestMapping(value = "/findAll")
    public AjaxResult findAll(){
        List<User> all = sysUserService.findAll();
        return new AjaxResult(all);
    }

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
        sysUser.setState(0);
        sysUser.setCreateTime(new Date());
        String password = new Md5Hash(sysUser.getPassword()).toString();
        sysUser.setPassword(password);
        Integer insert = sysUserService.insert(sysUser);
        return new AjaxResult(insert);
    }

    @ResponseBody
    @RequestMapping(value = "/findAdminById")
    public AjaxResult findAdminById(Integer id){
        User user = sysUserService.selectByPrimaryKey(id);

        return new AjaxResult(user);
    }



    //根据id删除
    @ResponseBody
    @RequestMapping(value = "/admindelete")
    public AjaxResult adminDelete(Integer id){
        Integer integer = sysUserService.deletByUserId(id);
        return new AjaxResult(integer);

    }

    //通过id查找
    @ResponseBody
    @RequestMapping(value = "/findbyId")
    public AjaxResult findById(HttpServletRequest request, HttpServletResponse response, Integer id) {

        System.out.println(id);
        User byId = sysUserService.findById(id);
        System.out.println(byId);
        request.getSession().setAttribute("userId", byId);

        return new AjaxResult(byId);
    }

    //找到session中的id
    @ResponseBody
    @RequestMapping(value = "/getmodipwd")
    public AjaxResult modi(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("userId");
        return new AjaxResult(user);
    }

    //修改密码
    @ResponseBody
    @RequestMapping(value = "/updatepwd")
    public AjaxResult updatePwd(User record){
        String password = record.getPassword();
        System.out.println(password);

        Integer integer = sysUserService.updatePwd(record);
        System.out.println(password);
        return new AjaxResult(integer);
    }

}
