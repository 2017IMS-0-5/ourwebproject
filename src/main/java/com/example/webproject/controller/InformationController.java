package com.example.webproject.controller;

import com.example.webproject.entity.AdSearch;
import com.example.webproject.entity.InfoClass;
import com.example.webproject.entity.Information;
import com.example.webproject.entity.UserFavor;
import com.example.webproject.service.InfoClassService;
import com.example.webproject.service.InformationService;
import com.example.webproject.service.UserFavorService;
import com.example.webproject.vo.Response;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/info")
public class InformationController {//信息文件相关控制（检索、查询、浏览）
    @Autowired
    private InformationService informationService;
    @Autowired
    private InfoClassService infoClassService;
    @Autowired
    private UserFavorService userFavorService;

   //以下是测试页
    /**
   @GetMapping("/test")//测试页
    public ModelAndView testInfoBean(){

       ModelAndView modelAndView=new ModelAndView("testInformationBean");//以“testInformationBean.jsp”为View
       modelAndView.addObject("info",informationService.selectInfoById("zLao-28BK2xwVAvQU9e2").get());//加入“info”数据模型
       Pageable pageable= PageRequest.of(0,20);
       List<Information> list=new ArrayList<>();
       for(Information information:informationService.show("job","sxxx",pageable)){
          list.add(information);
       }
       modelAndView.addObject("infoList",list);//加入“infoList”数据模型
       return modelAndView;
   }
    @GetMapping("/header")//测试Header
    public ModelAndView testHeaderView(){
        return new ModelAndView("header");
    }

    @GetMapping("/content")//测试Content
    public ModelAndView testInfoCon(){
        return new ModelAndView("showCon");
    }
    **/

   //以下是MVC交互

    //一、全站检索功能
    /**
     * 普通检索页面
     * @return
     */
   @GetMapping("/generalSearch")
    public ModelAndView genSearchView(){
       return new ModelAndView("nosearch");
   }

    /**
     * 高级检索页面
     * @return
     */
    @GetMapping("/advancedSearch")
    public ModelAndView advSearchView(){
        List<Information> hotList=informationService.findHotInfo(10);
        ModelAndView modelAndView=new ModelAndView("susearch");
        modelAndView.addObject("hotList",hotList);
        return modelAndView;
    }

    /**
     * 模糊检索结果集获取
     * @param keyword
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/genSearchV")
    public ModelAndView genSearchResultView(
            @RequestParam(value = "keyword",required = false,defaultValue = "")String keyword,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page= informationService.generalSearch(keyword, pageable);
        List<Information> hotList=informationService.findHotInfo(10);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("nosearch");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("hotList",hotList);
        modelAndView.addObject("searchType","genSearchV");
        modelAndView.addObject("formulation","keywords="+keyword);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;

    }

    /**
     * 高级检索结果集获取
     * @param title
     * @param label
     * @param content
     * @param author
     * @param from
     * @param to
     * @param field
     * @param subject
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/adSearchV")
    public ModelAndView advSearchResultView(
            @RequestParam(value = "title",required = false,defaultValue = "")String title,
            @RequestParam(value = "label",required = false,defaultValue = "")String label,
            @RequestParam(value = "content",required = false,defaultValue = "")String content,
            @RequestParam(value = "author",required = false,defaultValue = "")String author,
            @RequestParam(value = "from",required = false,defaultValue = "")String from,
            @RequestParam(value = "to",required = false,defaultValue = "")String to,
            @RequestParam(value = "field",required = false,defaultValue = "")String field,
            @RequestParam(value = "subject",required = false,defaultValue = "")String subject,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        AdSearch adSearch=new AdSearch(title,label,content,author,field,subject,from,to);
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page= informationService.advancedSearch(adSearch,pageable);
        List<Information> hotList=informationService.findHotInfo(10);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        String formulation="title="+title;
        formulation+="&label="+label;
        formulation+="&content="+content;
        formulation+="&author="+author;
        formulation+="&to="+to;
        formulation+="&field="+field;
        formulation+="&subject="+subject;
        ModelAndView modelAndView=new ModelAndView("susearch");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("hotList",hotList);
        modelAndView.addObject("searchType","genSearchV");
        modelAndView.addObject("formulation",formulation);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;

    }

    //二、信息分类展示功能

    @GetMapping("/information")
    public ModelAndView showContent(
            @RequestParam(value = "infoId",required = true)String infoId//信息ID
    ){
        String account="201711260105";
        Information information=informationService.selectInfoById(infoId).get();
        information.setReadSize(information.getReadSize()+1);//阅读量+1
        informationService.updateInfo(information);
        String field=information.getField();
        String subject=information.getSubject();
        InfoClass infoClass=infoClassService.selectByFieldAndSubValue(field,subject);
        ModelAndView modelAndView=new ModelAndView("showCon");
        modelAndView.addObject("info",information);
        modelAndView.addObject("field",field);
        modelAndView.addObject("fieldValue","/"+field);
        modelAndView.addObject("subject",infoClass.getSubject());
        modelAndView.addObject("subjectValue","/"+subject);
        modelAndView.addObject("subjectList",infoClassService.selectByField(field));
        if(
                userFavorService.ifexistsFavor(account,infoId)
        ){
            modelAndView.addObject("favored","true");
        }
        else
            modelAndView.addObject("favored","false");
        return modelAndView;
    }



    /**
     * 1.就业信息首页
     * @return
     */
    @GetMapping("/job")
    public ModelAndView jyxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.show("job","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","就业信息");
        modelAndView.addObject("fieldValue","/job");
        modelAndView.addObject("subjectList",infoClassService.selectByField("job"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 2.通知公告首页
     * @return
     */
    @GetMapping("/notice")
    public ModelAndView tzggView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.show("notice","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","通知公告");
        modelAndView.addObject("fieldValue","/notice");
        modelAndView.addObject("subjectList",infoClassService.selectByField("notice"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 3.政策制度首页
     * @return
     */
    @GetMapping("/policy")
    public ModelAndView zczdView(
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.show("policy","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","政策制度");
        modelAndView.addObject("fieldValue","/policy");
        modelAndView.addObject("subjectList",infoClassService.selectByField("policy"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 4.其它信息
     * @return
     */
    @GetMapping("/other")
    public ModelAndView qtxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.show("other","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","其它信息");
        modelAndView.addObject("fieldValue","/other");
        modelAndView.addObject("subjectList",infoClassService.selectByField("other"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 各大信息主题页
     * @return
     */
    @GetMapping("/{field}/{subject}")
    public ModelAndView policySubView(
            @PathVariable("field")String field,
            @PathVariable("subject")String subject,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        Sort sort=Sort.by(orders);
        Pageable pageable= PageRequest.of(pageIndex,pageSize,sort);
        Page<Information> page=informationService.show(field,subject,pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        InfoClass infoClass=infoClassService.selectByFieldAndSubValue(field,subject);
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        switch (field)
        {
            case "job":modelAndView.addObject("field","就业信息");break;
            case "policy":modelAndView.addObject("field","政策制度");break;
            case "notice":modelAndView.addObject("field","通知公告");break;
            case "other":modelAndView.addObject("field","其它信息");break;
        }
        modelAndView.addObject("fieldValue","/"+field);
        modelAndView.addObject("subject",infoClass.getSubject());
        modelAndView.addObject("subjectValue","/"+subject);
        modelAndView.addObject("subjectList",infoClassService.selectByField(field));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }


    //三、信息收藏
    @PostMapping("/favor")
    public String addFavor(
            @RequestParam(value = "infoId",required = true)String infoId
    )  {
        String account="201711260105";
        try {
            UserFavor userFavor=new UserFavor(account,infoId);
            userFavorService.saveOrUpdateUserFavor(userFavor);
        }catch (Exception e){
        }
        return "redirect:/info/information?infoId="+infoId;
    }

    //四、URL跳转--清理URL
    @GetMapping("")
    public String redirect1() {
        return "redirect:/main";
    }

    @GetMapping("/")
    public String redirect2() {
        return "redirect:/main";
    }



   //以下是JSON交互，用于直接获取信息


    /**
     * 模糊检索结果集获取
     * @param keyword
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/genSearch")
    public ResponseEntity<Response> genSearchResult(
            @RequestParam(value = "keyword",required = false,defaultValue = "")String keyword,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
                                  ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=null;
        try {
            page = informationService.generalSearch(keyword, pageable);
        }catch (Exception e){
            return ResponseEntity.status((500)).body(new Response(false, e.getMessage()));
        }
        String list = JSONArray.fromObject(page).toString();
        return ResponseEntity.status(200).body(new Response(true,"查询成功！",list));

    }

    /**
     * 高级检索结果集获取
     * @param title
     * @param label
     * @param content
     * @param author
     * @param from
     * @param to
     * @param field
     * @param subject
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/adSearch")
    public ResponseEntity<Response> advSearchResult(
            @RequestParam(value = "title",required = false,defaultValue = "")String title,
            @RequestParam(value = "label",required = false,defaultValue = "")String label,
            @RequestParam(value = "content",required = false,defaultValue = "")String content,
            @RequestParam(value = "author",required = false,defaultValue = "")String author,
            @RequestParam(value = "from",required = false,defaultValue = "")String from,
            @RequestParam(value = "to",required = false,defaultValue = "")String to,
            @RequestParam(value = "field",required = false,defaultValue = "")String field,
            @RequestParam(value = "subject",required = false,defaultValue = "")String subject,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        AdSearch adSearch=new AdSearch(title,label,content,author,field,subject,from,to);
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=null;
        try {
            page = informationService.advancedSearch(adSearch,pageable);
        }catch (Exception e){
            return ResponseEntity.status((500)).body(new Response(false, e.getMessage()));
        }
        String list = JSONArray.fromObject(page).toString();
        return ResponseEntity.status(200).body(new Response(true,"查询成功！",list));

    }



}
