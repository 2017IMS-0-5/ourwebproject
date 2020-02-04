package com.example.webproject.controller;

import com.example.webproject.entity.Information;
import com.example.webproject.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

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

    @GetMapping("/tzggsubmit")
    public ModelAndView uploadTzgg(
            @RequestParam(value = "title",required = true)String title,
            @RequestParam(value = "field",required = true)String field,
            @RequestParam(value = "subject",required = true)String subject,
            @RequestParam(value = "labels",required = false,defaultValue = "null")String labels,
            @RequestParam(value = "content",required = true)String content
    ){
        Information information=new Information(field,subject,"author",labels,title,content,0,new Timestamp(System.currentTimeMillis()),"");
        informationService.saveInfo(information);
        return new ModelAndView("noteupload");
    }




}
