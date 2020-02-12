package com.example.webproject.controller;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.User;
import com.example.webproject.service.AdminService;
import com.example.webproject.service.InformationService;
import com.example.webproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {//处理整个系统相关的控制：登录、退出、注册

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private InformationService informationService;

    /**
     * 重定向到LOGIN
     * @return
     */
    @GetMapping("/")
    public String root(){
        return "redirect:/login";
    }

    @GetMapping("/login")//登录界面
    public ModelAndView testlogin(){
        return new ModelAndView("login");
    }

    @GetMapping("/main")//主页
    public ModelAndView testmain(HttpServletRequest request, HttpServletResponse response){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        ModelAndView modelAndView=new ModelAndView("main");
        modelAndView.addObject("infoList",informationService.findNewInfo(5));
        return modelAndView;
    }

}


