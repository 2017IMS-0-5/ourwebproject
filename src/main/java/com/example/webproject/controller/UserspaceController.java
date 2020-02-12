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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public ModelAndView zxtzView(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "4")int pageSize
    ){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.selectByLabel(user.getMajor(),pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("zxtz");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("user",user);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }
    /**
     * 2.个人主页——我的收藏
     * @return
     */
    @GetMapping("/wdsc")
    public ModelAndView wdscView(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "4")int pageSize
    ){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<UserFavor> page=userFavorService.getUserFavorByUserAccount(user.getAccount(),pageable);
        List<Information> list=new ArrayList<>();
        for(UserFavor userFavor:page){
            Optional<Information> information=informationService.selectInfoById(userFavor.getInfold());
            list.add(information.get());
        }
        ModelAndView modelAndView=new ModelAndView("wdsc");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("user",user);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }
    /**
     * 取消收藏
     * @param infold
     * @return
     */
    @GetMapping("/deleteUF")
    public String deleteUserFavor(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(value = "infold", required = true) String infold
    ) {
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        userFavorService.deleteUserFavor(infold,user.getAccount());
        return "redirect:/usersp/wdsc";
    }


    /**
     * 3.个人主页——我发布的留言
     * @return
     */
    @GetMapping("/fbly")
    public ModelAndView fblyView(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "4")int pageSize
    ){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Comment> page=commentService.showUserComments(user.getAccount(),pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        ModelAndView modelAndView=new ModelAndView("fbly");
        modelAndView.addObject("commList",list);
        modelAndView.addObject("user",user);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }
    /**
     * 4.个人主页——编辑资料
     * @return
     */
    @GetMapping("/bjzl")//返回
    public ModelAndView returnbjzl(HttpServletRequest request, HttpServletResponse response){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        ModelAndView modelAndView=new ModelAndView("the change of person information ");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    /**5.个人主页——修改密码
     * @return
     */
    @GetMapping("/xgmm")//返回
    public ModelAndView returnxgmm(HttpServletRequest request, HttpServletResponse response){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        ModelAndView modelAndView=new ModelAndView("change_password");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    /**
     * 6.修改密码
     * @param old_password
     * @param new_password
     * @param verify_new
     * @return
     */
    @GetMapping("/changepassword")//修改密码
    public ModelAndView testLoginCheck(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam(value = "old_password", required = true, defaultValue = "0000") String old_password,//value-变量名；required-参数是否必要
                                       @RequestParam(value = "new_password", required = true, defaultValue = "0000") String new_password,//defaultValue默认值
                                       @RequestParam(value = "verify_new", required = true, defaultValue = "0000") String verify_new
    ) {
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
        Boolean res;
        if (user.getPassword().equals(old_password)&&new_password.equals(verify_new)) {
            user.setPassword(new_password);
            userService.saveOrUpdateUser(user);
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
     * 7.重置密码
     * @return
     */
    @GetMapping("/resetPassword")
    public String resetPW(HttpServletRequest request, HttpServletResponse response){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        String new_pw = user.getAccount().substring(6,12);
        user.setPassword(new_pw);
        userService.saveOrUpdateUser(user);
        return "redirect:/usersp/xgmm";
    }
    /**
     * 8.留言板
     * @return
     */
    @GetMapping("/lyb")
    public ModelAndView lybView(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "3")int pageSize
    ){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return new ModelAndView("/login");
        }
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
    public String addComment(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "comment", required = true) String content
    ) {
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        commentService.addComment(new Comment(user.getAccount(),content));
        return "redirect:/usersp/lyb";

    }

}
