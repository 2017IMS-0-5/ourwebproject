package com.example.webproject.controller;

import com.example.webproject.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {//管理员相关控制
    @Autowired
    private InformationService informationService;


    //以下是测试页

    /**
     * 测试managerHeader
     * @return
     */
    @GetMapping("/header")
    public ModelAndView testHeaderView(){
        return new ModelAndView("managerheader");
    }

    @GetMapping("/navigator")
    public ModelAndView testNavi(){
        return new ModelAndView("Administratornavigatorbar");
    }
    //以下是页面显示


    @GetMapping("/tzggupload")
    public ModelAndView uploadTzggView(){
        return new ModelAndView("noteupload");
    }



    //以下是JSON交互
    //查询信息
    //修改信息
    //删除信息
    //上传信息
}
