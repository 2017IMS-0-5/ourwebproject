package com.example.webproject.controller;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.User;
import com.example.webproject.service.AdminService;
import com.example.webproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.dom.core.Element;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {//处理整个系统相关的控制：登录、退出、注册

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")//登录界面
    public ModelAndView testlogin(){
        return new ModelAndView("login");
    }

    @GetMapping("/main")//登录界面
    public ModelAndView testmain(){
        return new ModelAndView("main");
    }

    @PostMapping("/checkLogin")//登录
    public String testLoginCheck(
            @RequestParam(value = "account", required = true, defaultValue = "000000000000") String account,//value-变量名；required-参数是否必要
            @RequestParam(value = "password", required = true, defaultValue = "000000") String password,//defaultValue默认值
            @RequestParam(value = "role", required = true, defaultValue = "user") String role
    ) {
        if(role.equals("user"))
        {
            User user=userService.login(account,password);
            if(user!=null){
                return "redirect:/main";
            }
            else{
                return "redirect:/login";
            }
        }
        else{
            Admin admin=adminService.login(account,password);
            if(admin!=null){
                return "redirect:admin/generalShow";
            }
            else{
                return "redirect:/login";
            }
        }
    }
}


