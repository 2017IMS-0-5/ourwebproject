package com.example.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {//处理整个系统相关的控制：登录、退出、注册

    @RequestMapping
    @ResponseBody
    public String test1(){
        return "test:\"test\"";
    }
    /**
     * 测试页
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test:\"test\"";
    }

    @GetMapping("/login")//测试页-输出login
    public ModelAndView testLogin(){
        return new ModelAndView("login");
    }

    @GetMapping("/checkLogin")//测试-login
    public String testLoginCheck(
            @RequestParam(value = "account",required = true,defaultValue = "hahaha")String account,//value-变量名；required-参数是否必要
            @RequestParam(value = "password",required = true,defaultValue = "110")String password//defaultValue默认值
    ){
        if (account.equals("test") && password.equals("123456")){//如果账号密码正确就GetMapping/index
            return "redirect:/index";
        }
        return "redirect:/login";//否则GetMapping/login
    }

    @GetMapping("/index")//测试页-index
    public ModelAndView testJsp(){
        return new ModelAndView("main");
    }
}
