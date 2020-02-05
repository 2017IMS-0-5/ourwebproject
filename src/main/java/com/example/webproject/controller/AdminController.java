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


    //信息上传功能
    /**
     * 1.就业信息上传
     * @return
     */
    @GetMapping("/jobupload")
    public ModelAndView uploadJyxxView(){

        return new ModelAndView("jobUpload");
    }

    /**
     * 2.通知公告上传
     * @return
     */
    @GetMapping("/noticeupload")
    public ModelAndView uploadTzggView(){

        return new ModelAndView("noticeUpload");
    }

    /**
     * 3.政策制度上传
     * @return
     */
    @GetMapping("/policyupload")
    public ModelAndView uploadZczdView(){

        return new ModelAndView("policyUpload");
    }

    /**
     * 4.其它信息上传
     * @return
     */
    @GetMapping("/otherupload")
    public ModelAndView uploadQtxxView(){

        return new ModelAndView("otherUpload");
    }

    /**
     * 信息上传后的逻辑
     * @param title
     * @param field
     * @param subject
     * @param labels
     * @param content
     * @return
     */
    @PostMapping("/infosubmit")
    public String uploadJob(
            @RequestParam(value = "title",required = true)String title,
            @RequestParam(value = "field",required = true)String field,
            @RequestParam(value = "subject",required = true)String subject,
            @RequestParam(value = "labels",required = false,defaultValue = "")String labels,
            @RequestParam(value = "content",required = true)String content
    ){
        Information information=new Information(field,subject,"author",labels,title,content,0,new Timestamp(System.currentTimeMillis()),"");
        System.out.println(informationService.saveInfo(information));
        switch (field){
            case "job":return "redirect:/admin/jobupload";
            case "notice":return "redirect:/admin/noticeupload";
            case "policy":return "redirect:/admin/policyupload";
            case "other":return "redirect:/admin/otherupload";
            default:return "redirect:/admin/otherupload";
        }
    }





}
