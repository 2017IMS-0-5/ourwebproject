package com.example.webproject.controller;

import com.example.webproject.entity.AdSearch;
import com.example.webproject.entity.InfoClass;
import com.example.webproject.entity.Information;
import com.example.webproject.entity.UserFavor;
import com.example.webproject.repository.InformationRepository;
import com.example.webproject.service.InfoClassService;
import com.example.webproject.service.InformationService;
import com.example.webproject.service.UserFavorService;
import com.example.webproject.vo.Response;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InformationController {//信息文件相关控制（检索、查询、浏览）
    @Autowired
    private InformationService informationService;
    @Autowired
    private InfoClassService infoClassService;
    @Autowired
    private UserFavorService userFavorService;

   //以下是测试页
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

    //以下是JSON交互


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
        ModelAndView modelAndView=new ModelAndView("susearch");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("hotList",hotList);
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;

    }

    //二、信息分类展示功能

    @GetMapping("/information")
    public ModelAndView showContent(
            @RequestParam(value = "infoId",required = true)String infoId//信息ID
    ){
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
        if(true){
            modelAndView.addObject("favored","false");
        }
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
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
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
     * 1.1 就业信息-实习信息
     * @return
     */
    @GetMapping("/job/sxxx")
    public ModelAndView sxxxView(
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","sxxx",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","就业信息");
        modelAndView.addObject("fieldValue","/job");
        modelAndView.addObject("subject","实习信息");
        modelAndView.addObject("subjectValue","/sxxx");
        modelAndView.addObject("subjectList",infoClassService.selectByField("job"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 1.2 就业信息-选调信息
     * @return
     */
    @GetMapping("/job/xdxx")
    public ModelAndView xdxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","xdxx",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","就业信息");
        modelAndView.addObject("fieldValue","/job");
        modelAndView.addObject("subject","选调信息");
        modelAndView.addObject("subjectValue","/xdxx");
        modelAndView.addObject("subjectList",infoClassService.selectByField("job"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 1.3 就业信息-招聘会信息
     * @return
     */
    @GetMapping("/job/zphxx")
    public ModelAndView zphxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","zph",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","就业信息");
        modelAndView.addObject("fieldValue","/job");
        modelAndView.addObject("subject","招聘会信息");
        modelAndView.addObject("subjectValue","/zphxx");
        modelAndView.addObject("subjectList",infoClassService.selectByField("job"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 1.4 就业信息-往年就业信息
     * @return
     */
    @GetMapping("/job/wnjyxx")
    public ModelAndView wnjyxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","wnjy",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","就业信息");
        modelAndView.addObject("fieldValue","/job");
        modelAndView.addObject("subject","往年就业信息");
        modelAndView.addObject("subjectValue","/wnjyxx");
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
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
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
     * 2.1 通知公告-科研项目
     * @return
     */
    @GetMapping("/notice/kyxm")
    public ModelAndView kyxmView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","kyxm",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","通知公告");
        modelAndView.addObject("fieldValue","/notice");
        modelAndView.addObject("subject","科研项目");
        modelAndView.addObject("subjectValue","/kyxm");
        modelAndView.addObject("subjectList",infoClassService.selectByField("notice"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 2.2 通知公告-竞赛比赛
     * @return
     */
    @GetMapping("/notice/jsbs")
    public ModelAndView jsbsView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","jsbs",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","通知公告");
        modelAndView.addObject("fieldValue","/notice");
        modelAndView.addObject("subject","竞赛比赛");
        modelAndView.addObject("subjectValue","/jsbs");
        modelAndView.addObject("subjectList",infoClassService.selectByField("notice"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 2.3 通知公告-讲座通知
     * @return
     */
    @GetMapping("/notice/jztz")
    public ModelAndView jztzView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","jztz",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","通知公告");
        modelAndView.addObject("fieldValue","/notice");
        modelAndView.addObject("subject","讲座通知");
        modelAndView.addObject("subjectValue","/jztz");
        modelAndView.addObject("subjectList",infoClassService.selectByField("notice"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 2.4 通知公告-会议通知
     * @return
     */
    @GetMapping("/notice/hytz")
    public ModelAndView hytzView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","hytz",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","通知公告");
        modelAndView.addObject("fieldValue","/notice");
        modelAndView.addObject("subject","会议通知");
        modelAndView.addObject("subjectValue","/hytz");
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
    public ModelAndView zczdView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
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
     * 3.1 政策制度-保研政策
     * @return
     */
    @GetMapping("/policy/byzc")
    public ModelAndView byzcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","byzc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","政策制度");
        modelAndView.addObject("fieldValue","/policy");
        modelAndView.addObject("subject","保研政策");
        modelAndView.addObject("subjectValue","/byzc");
        modelAndView.addObject("subjectList",infoClassService.selectByField("policy"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 3.2 政策制度-招生政策
     * @return
     */
    @GetMapping("/policy/zszc")
    public ModelAndView zszcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","zszc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","政策制度");
        modelAndView.addObject("fieldValue","/policy");
        modelAndView.addObject("subject","招生政策");
        modelAndView.addObject("subjectValue","/zszc");
        modelAndView.addObject("subjectList",infoClassService.selectByField("policy"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 3.3 政策制度-培养政策
     * @return
     */
    @GetMapping("/policy/pyzc")
    public ModelAndView pyzcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","pyzc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","政策制度");
        modelAndView.addObject("fieldValue","/policy");
        modelAndView.addObject("subject","培养政策");
        modelAndView.addObject("subjectValue","/pyzc");
        modelAndView.addObject("subjectList",infoClassService.selectByField("policy"));
        modelAndView.addObject("pageIndex",pageIndex+1);
        modelAndView.addObject("pageTotal",page.getTotalPages());
        return modelAndView;
    }

    /**
     * 3.4 政策制度-其它政策
     * @return
     */
    @GetMapping("/policy/qtzc")
    public ModelAndView qtzcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","atzc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        ModelAndView modelAndView=new ModelAndView("jyxx");
        modelAndView.addObject("infoList",list);
        modelAndView.addObject("field","政策制度");
        modelAndView.addObject("fieldValue","/policy");
        modelAndView.addObject("subject","其它政策");
        modelAndView.addObject("subjectValue","/qtzc");
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
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
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

    //三、信息收藏
    @PostMapping("/favor")
    public void addFavor(
            @RequestParam(value = "infoId",required = true)String infoId,
            HttpServletResponse response
    ) throws IOException {
        String account="201711260105";
        try {
            UserFavor userFavor=new UserFavor(account,infoId);
            userFavorService.saveOrUpdateUserFavor(userFavor);
        }catch (Exception e){
        }
        response.sendRedirect("/info/information?infoId="+infoId);
    }


   //以下是JSON交互


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
