package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class MenuController {


    @RequestMapping(value = "/menuall")
        public String menuAll(){
        return "menu-list";
    }
}
