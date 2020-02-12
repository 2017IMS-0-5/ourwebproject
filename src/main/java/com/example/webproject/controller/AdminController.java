package com.example.webproject.controller;

import com.example.webproject.entity.*;
import com.example.webproject.repository.CommentRepository;
import com.example.webproject.repository.InformationRepository;
import com.example.webproject.repository.UserRepository;
import com.example.webproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {//管理员相关控制
    @Autowired
    private InformationService informationService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private AnalysisService analysisService;


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
    @GetMapping("/homepage")
    public ModelAndView homepage(){
        int student=userService.countAllUsers();
        int information=analysisService.countAllInfo();
        ModelAndView num=new ModelAndView("administrator homepage");
        num.addObject("student",student);
        num.addObject("information",information);
        return num;
    }
    /**
     * 以下是人员管理 管理员只能按照姓名和账号检索  人员类型必选
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/userSearch")
    public ModelAndView userSearch(@RequestParam(value = "pageIndex",required=false, defaultValue="0")int pageIndex,
                                   @RequestParam(value="pageSize",required=false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRole(1,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        ModelAndView modelAndView=new ModelAndView("Personnel management_user");
        modelAndView.addObject("userList",list);
        return modelAndView;
    }

    @GetMapping("/teachSearch")
    public ModelAndView teachSearch(@RequestParam(value = "pageIndex",required=false, defaultValue="0")int pageIndex,
                                   @RequestParam(value="pageSize",required=false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRole(2,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        ModelAndView modelAndView=new ModelAndView("Personnel management_user");
        modelAndView.addObject("userList",list);
        return modelAndView;
    }

    @GetMapping("/adminSearch")
    public ModelAndView adminSearch(@RequestParam(value = "pageIndex",required=false, defaultValue="0")int pageIndex,
                                   @RequestParam(value="pageSize",required=false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Admin> page=adminService.selectAllAdmin(pageable);
        List<Admin> list=new ArrayList<>();
        for(Admin admin:page){
            list.add(admin);
        }
        ModelAndView modelAndView=new ModelAndView("Personnel management_manager");
        modelAndView.addObject("adminList",list);
        return modelAndView;
    }

    @GetMapping("/checkUserSearch")
    public String checkUserSearch(@RequestParam(value = "role",required = false,defaultValue = "学生")String role,
                                  @RequestParam(value = "searchWay",required = false)String searchWay,
                                  @RequestParam(value = "searchWord",required = false)String searchWord
    ){
        if(role.equals("学生") && searchWay.equals("按姓名检索")){
            return "redirect:/admin/userByStuAndName?name="+searchWord;}
        else if(role.equals("教师") && searchWay.equals("按姓名检索")){
            return "redirect:/admin/userByTeaAndName?name="+searchWord;
        }
        else if(role.equals("管理员") && searchWay.equals("按姓名检索")){
            return "redirect:/admin/userByAdminAndName?name="+searchWord;
        }
        else if(role.equals("超级管理员") && searchWay.equals("按姓名检索")){
            return "redirect:/admin/userBySAdminAndName?name="+searchWord;
        }
        else if(role.equals("学生") && searchWay.equals("按年级检索")){
            return "redirect:/admin/userByStuAndGrade?grade="+searchWord;
        }
        else if(role.equals("教师") && searchWay.equals("按年级检索")){
            return "redirect:/admin/userByTeaAndGrade?grade="+searchWord;
        }
        else if(role.equals("学生") && searchWay.equals("按专业检索")){
            return "redirect:/admin/userByStuAndMajor?major="+searchWord;
        }
        else if(role.equals("教师") && searchWay.equals("按专业检索")){
            return "redirect:/admin/userByTeaAndMajor?major="+searchWord;
        }
        else if(role.equals("学生") && searchWay.equals("按账号检索")){
            return "redirect:/admin/userByStuAndAccount?account="+searchWord;
        }
        else if(role.equals("教师") && searchWay.equals("按账号检索")){
            return "redirect:/admin/userByTeaAndAccount?account="+searchWord;
        }
        else if(role.equals("管理员") && searchWay.equals("按账号检索")){
            return "redirect:/admin/userByAdminAndAccount?account="+searchWord;
        }
        else if(role.equals("超级管理员") && searchWay.equals("按账号检索")){
            return "redirect:/admin/userBySAdminAndAccount?account="+searchWord;
        }
        else return "redirect:/admin/userSearch";
    }

    @GetMapping("/userByStuAndName")
    public ModelAndView userByStuAndName(String name,
                                         @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndName(1,name,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByTeaAndName")
    public ModelAndView userByTeaAndName(String name,
                                         @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndName(2,name,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByAdminAndName")
    public ModelAndView userByAdminAndName(String name,
                                           @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Admin> page=adminService.selectByRoleAndName("manager",name,pageable);
        List<Admin> list=new ArrayList<>();
        for(Admin admin:page){
            list.add(admin);
        }
        return new ModelAndView("Personnel management_manager","adminList",list);
    }

    @GetMapping("/userBySAdminAndName")
    public ModelAndView userBySAdminAndName(String name,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Admin> page=adminService.selectByRoleAndName("supermanager",name,pageable);
        List<Admin> list=new ArrayList<>();
        for(Admin admin:page){
            list.add(admin);
        }
        return new ModelAndView("Personnel management_manager","adminList",list);
    }

    @GetMapping("/userByStuAndGrade")
    public ModelAndView userByStuAndGrade(String grade,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndGrade(1,grade,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByTeaAndGrade")
    public ModelAndView userByTeaAndGrade(String grade,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndGrade(2,grade,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByStuAndMajor")
    public ModelAndView userByStuAndMajor(String major,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndMajor(1,major,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByTeaAndMajor")
    public ModelAndView userByTeaAndMajor(String major,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndMajor(2,major,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByStuAndAccount")
    public ModelAndView userByStuAndAccount(String account,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndAccount(1,account,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByTeaAndAccount")
    public ModelAndView userByTeaAndAccount(String account,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.listUsersByRoleAndAccount(2,account,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("Personnel management_user","userList",list);
    }

    @GetMapping("/userByAdminAndAccount")
    public ModelAndView userByAdminAndAccount(String account,
                                              @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                              @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Admin> page=adminService.selectByRoleAndAccount("manager",account,pageable);
        List<Admin> list=new ArrayList<>();
        for(Admin admin:page){
            list.add(admin);
        }
        return new ModelAndView("Personnel management_manager","adminList",list);
    }

    @GetMapping("/userBySAdminAndAccount")
    public ModelAndView userBySAdminAndAccount(String account,
                                               @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                               @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Admin> page=adminService.selectByRoleAndAccount("supermanager",account,pageable);
        List<Admin> list=new ArrayList<>();
        for(Admin admin:page){
            list.add(admin);
        }
        return new ModelAndView("Personnel management_manager","adminList",list);
    }



    /**
     * 以下是信息展示
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/infoSearch")
    public ModelAndView infoSearch(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","实习信息",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("Message management");
        modelAndView.addObject("infoList",list);
        return modelAndView;
    }

    @GetMapping("/checkInfoSearch")
    public String checkInfoSearch(@RequestParam(value = "field",required = false,defaultValue = "全部")String field,
                                  @RequestParam(value = "searchWay",required = false)String searchWay,
                                  @RequestParam(value = "searchWord",required = false)String searchWord
    ){
        if(searchWay.equals("按二级标题检索")){
            return "redirect:/admin/infoByFieldAndSubject?field="+field+"&subject="+searchWord;
        }
        else if(searchWay.equals("按文章标题检索")){
            return "redirect:/admin/infoByFieldAndTitle?field="+field+"&title="+searchWord;
        }
        else if(searchWay.equals("按发布者检索")){
            return "redirect:/admin/infoByFieldAndAuthor?field="+field+"&author="+searchWord;
        }
        else if(searchWay.equals("按关键词检索")){
            return "redirect:/admin/infoByFieldAndLabels?field="+field+"&labels="+searchWord;
        }
        else return "redirect:/admin/infoSearch";
    }

    @GetMapping("/infoByFieldAndSubject")
    public ModelAndView infoByFieldAndSubject(String field,String subject,
                                              @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                              @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("all",subject,pageable);
        if(field.equals("全部")){
            page=informationService.show("all",subject,pageable);
        }
        else if(field.equals("就业信息")){
            page=informationService.show("job",subject,pageable);
        }
        else if(field.equals("通知公告")){
            page=informationService.show("notice",subject,pageable);
        }
        else if(field.equals("政策规章")){
            page=informationService.show("policy",subject,pageable);
        }
        else if(field.equals("其它信息")){
            page=informationService.show("other",subject,pageable);
        }
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("Message management","infoList",list);
    }

    @GetMapping("/infoByFieldAndTitle")
    public ModelAndView infoByFieldAndTitle(String field,String title,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        AdSearch adSearch=new AdSearch(title,"","","",field,"","","");
        Page<Information> page=informationService.advancedSearch(adSearch,pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("Message management","infoList",list);
    }

    @GetMapping("/infoByFieldAndAuthor")
    public ModelAndView infoByFieldAndAuthor(String field,String author,
                                             @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        AdSearch adSearch=new AdSearch("","","",author,field,"","","");
        Page<Information> page=informationService.advancedSearch(adSearch,pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("Message management","infoList",list);
    }

    @GetMapping("/infoByFieldAndLabels")
    public ModelAndView infoByFieldAndLabels(String field,String labels,
                                             @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        AdSearch adSearch=new AdSearch("",labels,"","",field,"","","");
        Page<Information> page=informationService.advancedSearch(adSearch,pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("Message management","infoList",list);
    }

    //以下是留言管理

    @GetMapping("/commentSearch")
    public ModelAndView commentSearch(@RequestParam(value = "pageIndex",required=false, defaultValue="0")int pageIndex,
                                      @RequestParam(value="pageSize",required=false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Comment> page=commentService.getAllCommentByTime(pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        ModelAndView modelAndView=new ModelAndView("comment management");
        modelAndView.addObject("commList",list);
        return modelAndView;
    }

    @GetMapping("/commentByAccountAndTime")
    public ModelAndView CommentByAccountAndTime(@RequestParam(value = "userAccount",required = false)String userAccount,
                                                @RequestParam(value = "createTime",required = false) Date createTime,
                                                @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                                @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Comment> page=commentService.getByDateAndUserAccount(createTime,userAccount,pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        return new ModelAndView("comment management","commList",list);
    }

    //以下是信息统计
    @GetMapping("/infoStatistics")
    public ModelAndView infoStatistics(){
        ModelAndView modelAndView=new ModelAndView("infoStatistics");
        List<Integer> readList=analysisService.getReadSizeByField();
        modelAndView.addObject("readDataofjob",readList.get(0));
        modelAndView.addObject("readDataofnotice",readList.get(1));
        modelAndView.addObject("readDataofpolicy",readList.get(2));
        modelAndView.addObject("readDataofother",readList.get(3));
        List<Integer> sizeList=analysisService.getInfoSizeByField();
        modelAndView.addObject("sizeDataofjob",sizeList.get(0));
        modelAndView.addObject("sizeDataofnotice",sizeList.get(1));
        modelAndView.addObject("sizeDataofpolicy",sizeList.get(2));
        modelAndView.addObject("sizeDataofother",sizeList.get(3));
        List<Integer> hotList=new ArrayList<>();
        for(int i=0;i<4;i++){
            hotList.add(readList.get(i)/sizeList.get(i));
        }
        modelAndView.addObject("hotDataofjob",hotList.get(0));
        modelAndView.addObject("hotDataofnotice",hotList.get(1));
        modelAndView.addObject("hotDataofpolicy",hotList.get(2));
        modelAndView.addObject("hotDataofother",hotList.get(3));
        return modelAndView;
    }

    @GetMapping("/userstatistics")
    public ModelAndView userstatistics(){
        ModelAndView modelAndView=new ModelAndView("userStatistics");
        modelAndView.addObject("dataOfStu",userService.countUserByRole(1));
        modelAndView.addObject("dataOfTea",userService.countUserByRole(2));
        modelAndView.addObject("dataOfGrade1",userService.countUserByRoleAndGrade(1,"2019"));
        modelAndView.addObject("dataOfGrade2",userService.countUserByRoleAndGrade(1,"2018"));
        modelAndView.addObject("dataOfGrade3",userService.countUserByRoleAndGrade(1,"2017"));
        modelAndView.addObject("dataOfGrade4",userService.countUserByRoleAndGrade(1,"2016"));
        modelAndView.addObject("dataOfAdmin",adminService.countByRole("manager"));
        modelAndView.addObject("dataOfSAdmin",adminService.countByRole("supermanager"));
        return modelAndView;
    }
/*
    //以下是管理界面的修改删除
    @GetMapping("/userUpdate")//表单value用得到
    public ModelAndView userUpdate(long id){
        User oldUser=userService.getUserById(id).get();
        ModelAndView modelAndView=new ModelAndView("personnel management_student");
        modelAndView.addObject("id",oldUser.getId());//不改
        modelAndView.addObject("password",oldUser.getPassword());//不改
        modelAndView.addObject("role",oldUser.getRole());
        modelAndView.addObject("grade",oldUser.getGrade());
        modelAndView.addObject("major",oldUser.getMajor());
        modelAndView.addObject("account",oldUser.getAccount());
        modelAndView.addObject("name",oldUser.getName());
        modelAndView.addObject("gender",oldUser.getGender());
        modelAndView.addObject("email",oldUser.getEmail());
        return modelAndView;
    }*/
    //表单提交
    @PostMapping("/userInsert")
    public String userInsert(@RequestParam(value = "role",required = true)String role,
                                   @RequestParam(value = "grade",required = true)String grade,
                                   @RequestParam(value = "major",required = false)String major,
                                   @RequestParam(value = "account",required = true)String account,
                                   @RequestParam(value = "name",required = true)String name,
                                   @RequestParam(value = "gender",required = true)String gender,
                                   @RequestParam(value = "email",required = true)String email,
                                   @RequestParam(value = "password",required = false)String password
    ){
        int roleNUm=1;
        if(role.equals("教师")){
            int roleNum=2;
        }
        User newUser=new User(name,email,password,account,gender,grade,major,roleNUm);
        User checkNew=userService.registerUser(newUser);
        if(checkNew==null){
            return "redirect:/main/error";
        }
        else{
            return "redirect:/admin/userSearch";
        }
    }

    @PostMapping("/userSubmit")
    public String userSubmit(@RequestParam(value = "role",required = true)String role,
                             @RequestParam(value = "grade",required = true)String grade,
                             @RequestParam(value = "major",required = false)String major,
                             @RequestParam(value = "account",required = true)String account,
                             @RequestParam(value = "name",required = true)String name,
                             @RequestParam(value = "gender",required = true)String gender,
                             @RequestParam(value = "email",required = true)String email,
                             @RequestParam(value = "id",required = false)String id,
                             @RequestParam(value = "password",required = false)String password
    ){
        int roleNUm=1;
        if(role.equals("教师")){
            int roleNum=2;
        }
        User oldUser=userService.selectByAccount(account);
        Long oldUserId=oldUser.getId();
        String oldUserPassword=oldUser.getPassword();
        User newUser=new User(name,email,oldUserPassword,account,gender,grade,major,roleNUm);
        User checkNew=userService.saveOrUpdateUser(newUser);
        if(checkNew==null){
            return "redirect:/main/error";
        }
        else{
            userService.removeUser(oldUserId);
            return "redirect:/admin/userSearch";
        }
    }

    @GetMapping("/userDelete")
    public String userDelete(long id){
        userService.removeUser(id);
        return "redirect:/admin/userSearch";
    }

    @GetMapping("/adminInsert")
    public ModelAndView adminInsert(Admin admin){
        Admin newAdmin=new Admin(admin.getAccount(),admin.getPassword(),admin.getName(),admin.getRole());
        Admin checkAdmin=adminService.SaveNewAdmin(newAdmin);
        if(checkAdmin==null){
            return new ModelAndView("error");
        }
        else{
            return new ModelAndView("Personnel management_manager");
        }
    }

    @PostMapping("/adminSubmit")
    public String adminSubmit(@RequestParam(value = "role",required = true)String role,
                              @RequestParam(value = "account",required = true)String account,
                              @RequestParam(value = "name",required = true)String name
    ){
        Admin oldAdmin=adminService.selectByAccount(account);
//        long id=oldAdmin.getId();
        String password=oldAdmin.getPassword();
        Admin newAdmin=new Admin(account,password,name,role);
        Admin checknew=adminService.UpdateAdmin(newAdmin);
        if(checknew==null){
            return "redirect:/main/error";
        }
        else{
//            userService.removeUser(id);
            return "redirect:/admin/adminSearch";
        }
    }

    @GetMapping("/adminDelete")
    public String adminDelete(long id){
        adminService.DeleteById(id);
        return "redirect:/admin/adminSearch";
    }

    @GetMapping("/commentDelete")
    public ModelAndView commentDelete(long id){
        commentService.removeComment(id);
        return new ModelAndView("comment management");
    }
/*
    @GetMapping("/infoUpdate")
    public ModelAndView infoUpdate(String id){
        Information oldInfo=informationService.selectInfoById(id).get();
        ModelAndView modelAndView=new ModelAndView("infoUpdate");
        modelAndView.addObject("id",oldInfo.getId());
        modelAndView.addObject("field",oldInfo.getField());
        modelAndView.addObject("subject",oldInfo.getSubject());
        modelAndView.addObject("author",oldInfo.getAuthor());
        modelAndView.addObject("labels",oldInfo.getLabels());
        modelAndView.addObject("title",oldInfo.getTitle());
        modelAndView.addObject("content",oldInfo.getContent());
        modelAndView.addObject("readSize",oldInfo.getReadSize());
        modelAndView.addObject("createTime",oldInfo.getCreateTime());//不改
        modelAndView.addObject("relation",oldInfo.getRelation());
        return modelAndView;
    }*/
    //表单提交
    @PostMapping("/infoSubmit")
    public String infoSubmit(@RequestParam(value = "field",required = true)String field,
                             @RequestParam(value = "subject",required = true)String subject,
                             @RequestParam(value = "author",required = true)String author,
                             @RequestParam(value = "labels",required = false)String labels,
                             @RequestParam(value = "title",required = true)String title,
                             @RequestParam(value = "content",required = true)String content,
                             @RequestParam(value = "readSize",required = true)int readSize,
                             @RequestParam(value = "id",required = true)String id,//不改
                             @RequestParam(value = "relation",required = true)String relation
    ){
        Information newInfo=new Information(field,subject,author,labels,title,content,readSize,new Timestamp(System.currentTimeMillis()),relation);
        Information checknew=informationService.updateInfo(newInfo);
        if(checknew==null){
            return "redirect:/main/error";
        }
        else{
            informationService.deleteInfoById(id);
            return "redirect:/admin/infoSearch";
        }
    }

    @GetMapping("/infoDelete")
    public ModelAndView infoDelete(String id){
        informationService.deleteInfoById(id);
        return new ModelAndView("Message management");
    }



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
            @RequestParam(value = "content",required = true)String content,
            //特征信息
            @RequestParam(value = "corporation",required = false,defaultValue = "")String corporation,
            @RequestParam(value = "address",required = false,defaultValue = "")String address,
            @RequestParam(value = "salary",required = false,defaultValue = "")String salary,
            @RequestParam(value = "call",required = false,defaultValue = "")String call,
                    HttpServletRequest request
    ){
        if(!corporation.equals("") && !corporation.equals("undefined")){
            content="【公司名称】 "+corporation+"\n"+content;
        }
        if(!address.equals("") && !address.equals("undefined")){
            content="【工作地点】 "+address+"\n"+content;
        }
        if(!salary.equals("") && !salary.equals("undefined")){
            content="【薪资待遇】 "+salary+"\n"+content;
        }
        if(!call.equals("") && !call.equals("undefined")){
            content="【联系方式】 "+call+"\n"+content;
        }
        Admin admin=(Admin)request.getSession().getAttribute("admin");
        String author=admin.getName();
        Information information=new Information(field,subject,author,labels,title,content,0,new Timestamp(System.currentTimeMillis()),"");
        System.out.println(informationService.saveInfo(information));
        switch (field){
            case "job":
                return "redirect:/admin/jobupload";
            case "notice":
                return "redirect:/admin/noticeupload";
            case "policy":
                return "redirect:/admin/policyupload";
            case "other":
                return "redirect:/admin/otherupload";
            default:return "redirect:/admin/otherupload";
        }
    }





}
