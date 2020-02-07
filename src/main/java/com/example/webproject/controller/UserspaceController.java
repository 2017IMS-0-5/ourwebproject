package com.example.webproject.controller;

import com.example.webproject.entity.*;
import com.example.webproject.service.CommentService;
import com.example.webproject.service.InformationService;
import com.example.webproject.service.UserFavorService;
import com.example.webproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usersp")
public class UserspaceController {//用户空间相关功能
    @Autowired
    private UserService userService;
    @Autowired
    private UserFavorService userFavorService;
    @Autowired
    private InformationService informationService;
    @Autowired
    private CommentService commentService;

    /**
     * 1.个人主页——最新通知
     * @return
     */
    @GetMapping("/zxtz")
    public ModelAndView zxtzView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.selectByLabel("信管",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("zxtz");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }
    /**
     * 2.个人主页——我的收藏
     * @return
     */
    @GetMapping("/wdsc")
    public ModelAndView wdscView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<UserFavor> page=userFavorService.getUserFavorByUserAccount("201711260115",pageable);
        List<Information> list=new ArrayList<>();
        for(UserFavor userFavor:page){
            Optional<Information> information=informationService.selectInfoById(userFavor.getInfold());
            list.add(information.get());
        }
        ModelAndView modelAndView=new ModelAndView("wdsc");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }
    /**
     * 3.个人主页——我发布的留言
     * @return
     */
    @GetMapping("/fbly")
    public ModelAndView fblyView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Comment> page=commentService.showUserComments("201711260115",pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        ModelAndView modelAndView=new ModelAndView("fbly");
        modelAndView.addObject("commList",list);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }
    /**
     * 4.个人主页——编辑资料
     * @return
     */
    @GetMapping("/bjzl")//返回
    public ModelAndView returnbjzl(){
        return new ModelAndView("the change of person information ");
    }

    /**5.个人主页——修改密码
     * @return
     */
    @GetMapping("/xgmm")//返回
    public ModelAndView returnxgmm(){
        return new ModelAndView("change_password");
    }

    /**
     * 6.修改密码
     * @param old_password
     * @param new_password
     * @param verify_new
     * @return
     */
    @GetMapping("/changepassword")//修改密码
    public ModelAndView testLoginCheck(
            @RequestParam(value = "old_password", required = true, defaultValue = "0000") String old_password,//value-变量名；required-参数是否必要
            @RequestParam(value = "new_password", required = true, defaultValue = "0000") String new_password,//defaultValue默认值
            @RequestParam(value = "verify_new", required = true, defaultValue = "0000") String verify_new
    ) {
        Optional<User> user = userService.getUserById((long) 1);
        Boolean res;
        if (user.get().getPassword().equals(old_password)&&new_password.equals(verify_new)) {
            user.get().setPassword(new_password);
            userService.saveOrUpdateUser(user.get());
            res=true;
        }
        else{
            res=false;
        }
        ModelAndView modelAndView=new ModelAndView("Checkpassword");
        modelAndView.addObject("res",res);
        return modelAndView;
    }
    /**
     * 7.留言板
     * @return
     */
    @GetMapping("/lyb")
    public ModelAndView lybView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "3")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Comment> page=commentService.getAllCommentByTime(pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        ModelAndView modelAndView=new ModelAndView("message_board");
        modelAndView.addObject("commList",list);
        modelAndView.addObject("row", page.getTotalElements());
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageSize", pageSize);
        modelAndView.addObject("pageTotal", page.getTotalPages());
        return modelAndView;
    }
    @GetMapping("/addComment")//添加评论
    public String addComment(@RequestParam(value = "comment", required = true, defaultValue = " ") String content) {
        commentService.addComment(new Comment("201711260111",content));
        return "redirect:/usersp/lyb";

    }

}
