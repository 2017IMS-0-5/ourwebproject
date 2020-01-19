package com.example.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/index")//测试页
    public ModelAndView testJsp(){
        return new ModelAndView("test");
    }
}
