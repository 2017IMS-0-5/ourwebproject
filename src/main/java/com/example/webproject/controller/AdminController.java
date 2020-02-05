package com.example.webproject.controller;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.Comment;
import com.example.webproject.entity.Information;
import com.example.webproject.entity.User;
import com.example.webproject.repository.CommentRepository;
import com.example.webproject.repository.InformationRepository;
import com.example.webproject.repository.UserRepository;
import com.example.webproject.service.AdminService;
import com.example.webproject.service.CommentService;
import com.example.webproject.service.InformationService;
import com.example.webproject.service.UserService;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {//管理员相关控制
    @Autowired
    private InformationService informationService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;


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

    @GetMapping("/generalShow")
    public ModelAndView generalShow(){
        return new ModelAndView("admin");
    }

 /*   /**
     * 以下是人员管理 管理员只能按照姓名和账号检索  人员类型必选
     * @param pageIndex
     * @param pageSize
     * @return
     */
/*    @GetMapping("/userSearch")
    public ModelAndView userSearch(@RequestParam(value = "pageIndex",required=false, defaultValue="0")int pageIndex,
                                   @RequestParam(value="pageSize",required=false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<User> page=userRepository.findAll(pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        ModelAndView modelAndView=new ModelAndView("personnel management");
        modelAndView.addObject("userAll",list);
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
        else if(searchWay.equals("按年级检索")){
            return "redirect:/admin/userByRoleAndGrade?role="+role+"&grade="+searchWord;
        }
        else if(searchWay.equals("按专业检索")){
            return "redirect:/admin/userByRoleAndMajor?role="+role+"&major="+searchWord;
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
        Page<User> page=userService.listUsersByRole(1,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("personnel management","userByStuAndNamelist",list);
    }

    @GetMapping("/userByTeaAndName")
    public ModelAndView userByTeaAndName(String name,
                                         @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.select(2,name,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("personnel management","userByTeaAndNamelist",list);
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
        return new ModelAndView("personnel management","userByAdminAndNamelist",list);
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
        return new ModelAndView("personnel management","userBySAdminAndNamelist",list);
    }

    @GetMapping("/userByRoleAndGrade")
    public ModelAndView userByRoleAndGrade(String role,String grade,
                                           @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userRepository.findAll(pageable);
        if(role.equals("学生")){
            page=userService.select(1,grade,pageable);
        }
        else if(role.equals("教师")){
            page=userService.select(2,grade,pageable);
        }
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("message management","infoByFieldAndSubjectlist",list);
    }

    @GetMapping("/userByRoleAndMajor")
    public ModelAndView userByRoleAndMajor(String role,String major,
                                           @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userRepository.findAll(pageable);
        if(role.equals("学生")){
            page=userService.select(1,major,pageable);
        }
        else if(role.equals("教师")){
            page=userService.select(2,major,pageable);
        }
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("message management","infoByFieldAndSubjectlist",list);
    }

    @GetMapping("/userByStuAndAccount")
    public ModelAndView userByStuAndAccount(String account,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.select(1,account,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("personnel management","userByStuAndAccountlist",list);
    }

    @GetMapping("/userByTeaAndAccount")
    public ModelAndView userByTeaAndAccount(String account,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<User> page=userService.select(2,account,pageable);
        List<User> list=new ArrayList<>();
        for(User user:page){
            list.add(user);
        }
        return new ModelAndView("personnel management","userByTeaAndAccountlist",list);
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
        return new ModelAndView("personnel management","userByAdminAndAccountlist",list);
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
        return new ModelAndView("personnel management","userBySAdminAndAccountlist",list);
    }
*/
/*
    /**
     * 以下是信息展示
     * @param pageIndex
     * @param pageSize
     * @return
     */
/*    @GetMapping("/infoSearch")
    public ModelAndView infoSearch(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationRepository.findAll(pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("message management");
        modelAndView.addObject("infoAll",list);
        return modelAndView;
    }

    @GetMapping("/checkInfoSearch")
    public String checkInfoSearch(@RequestParam(value = "field",required = false,defaultValue = "全部")String field,
                                  @RequestParam(value = "searchWay",required = false)String searchWay,
                                  @RequestParam(value = "searchWord",required = false)String searchWord
    ){
        if(searchWay.equals("null")){
            return "redirect:/admin/infoByField?field="+field;}
        else if(searchWay.equals("按二级标题检索")){
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

    @GetMapping("/infoByField")
    public ModelAndView infoByField(String field,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationRepository.findAll(pageable);
        if(field.equals("全部")){
            page=informationRepository.findAll(pageable);
        }
        else if(field.equals("就业信息")){
            page=informationService.show("job","all",pageable);
        }
        else if(field.equals("通知公告")){
            page=informationService.show("notice","all",pageable);
        }
        else if(field.equals("政策规章")){
            page=informationService.show("policy","all",pageable);
        }
        else if(field.equals("其它信息")){
            page=informationService.show("other","all",pageable);
        }
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("message management","infoByFieldlist",list);
    }

    @GetMapping("/infoByFieldAndSubject")
    public ModelAndView infoByFieldAndSubject(String field,String subject,
                                              @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                              @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationRepository.findAll(pageable);
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
        return new ModelAndView("message management","infoByFieldAndSubjectlist",list);
    }

    @GetMapping("/infoByFieldAndTitle")
    public ModelAndView infoByFieldAndTitle(String field,String title,
                                            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);

        // 按一级标题+文章标题检索  待更

        Page<Information> page=informationRepository.findAll(pageable);
        if(field.equals("全部")){
            page=informationService.show("all",title,pageable);
        }
        else if(field.equals("就业信息")){
            page=informationService.show("job",title,pageable);
        }
        else if(field.equals("通知公告")){
            page=informationService.show("notice",title,pageable);
        }
        else if(field.equals("政策规章")){
            page=informationService.show("policy",title,pageable);
        }
        else if(field.equals("其它信息")){
            page=informationService.show("other",title,pageable);
        }
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("message management","infoByFieldAndTitlelist",list);
    }

    @GetMapping("/infoByFieldAndAuthor")
    public ModelAndView infoByFieldAndAuthor(String field,String author,
                                             @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);

         //按一级标题+作者检索  待更

        Page<Information> page=informationRepository.findAll(pageable);
        if(field.equals("全部")){
            page=informationService.show("all",author,pageable);
        }
        else if(field.equals("就业信息")){
            page=informationService.show("job",author,pageable);
        }
        else if(field.equals("通知公告")){
            page=informationService.show("notice",author,pageable);
        }
        else if(field.equals("政策规章")){
            page=informationService.show("policy",author,pageable);
        }
        else if(field.equals("其它信息")){
            page=informationService.show("other",author,pageable);
        }
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("message management","infoByFieldAndAuthorlist",list);
    }

    @GetMapping("/infoByFieldAndLabels")
    public ModelAndView infoByFieldAndLabels(String field,String labels,
                                             @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);

         //按一级标题+关键词（标签）检索  待更

        Page<Information> page=informationRepository.findAll(pageable);
        if(field.equals("全部")){
            page=informationService.show("all",labels,pageable);
        }
        else if(field.equals("就业信息")){
            page=informationService.show("job",labels,pageable);
        }
        else if(field.equals("通知公告")){
            page=informationService.show("notice",labels,pageable);
        }
        else if(field.equals("政策规章")){
            page=informationService.show("policy",labels,pageable);
        }
        else if(field.equals("其它信息")){
            page=informationService.show("other",labels,pageable);
        }
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("message management","infoByFieldAndLabels",list);
    }

    //以下是留言管理

    @GetMapping("/commentSearch")
    public ModelAndView commentSearch(@RequestParam(value = "pageIndex",required=false, defaultValue="0")int pageIndex,
                                      @RequestParam(value="pageSize",required=false,defaultValue = "100")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Comment> page=commentRepository.findAll(pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        ModelAndView modelAndView=new ModelAndView("comment management");
        modelAndView.addObject("commentAll",list);
        return modelAndView;
    }

    @GetMapping("/commentByAccountAndTime")
    public ModelAndView CommentByAccountAndTime(@RequestParam(value = "userAccount",required = false)String userAccount,
                                                @RequestParam(value = "createTime",required = false) Date createTime,
                                                @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                                @RequestParam(value = "pageSize",required = false,defaultValue = "100")int pageSize
    ){
        Pageable pageable=PageRequest.of(pageIndex,pageSize);
        Page<Comment> page=commentService.select(userAccount,createTime,pageable);
        List<Comment> list=new ArrayList<>();
        for(Comment comment:page){
            list.add(comment);
        }
        return new ModelAndView("comment management","commentByAccountAndTimelist",list);
    }
*/
    //以下是信息统计
/*    @GetMapping("/infoStatistics")
    public ModelAndView infoStatistics(){
        ModelAndView modelAndView=new ModelAndView("infostatistics");
        modelAndView.addObject("dataofzcxx",informationService.selectInfoById());
        return modelAndView;
    }
*/
    @GetMapping("/userstatistics")
    public ModelAndView userstatistics(){
        ModelAndView modelAndView=new ModelAndView("userstatistics");
        modelAndView.addObject("dataOfAdmin",adminService.countByRole("manager"));
        modelAndView.addObject("dataOfSAdmin",adminService.countByRole("supermanager"));
        return modelAndView;
    }

//以下是信息上传
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
