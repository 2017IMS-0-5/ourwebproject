package com.example.webproject.controller;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import com.example.webproject.service.InformationService;
import com.example.webproject.vo.Response;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InformationController {//信息文件相关控制（检索、查询、浏览）
   @Autowired
   private InformationService informationService;

   //以下是测试页
   @GetMapping("/test")//测试页
    public ModelAndView testInfoBean(){

       ModelAndView modelAndView=new ModelAndView("testInformationBean");//以“testInformationBean.jsp”为View
       modelAndView.addObject("info",informationService.selectInfoById("fvKKxm8BTa4F5iFyOyDz").get());//加入“info”数据模型
       Pageable pageable= PageRequest.of(0,20);
       List<Information> list=new ArrayList<>();
       for(Information information:informationService.show("job","sxxx",pageable)){
          list.add(information);
       }
       modelAndView.addObject("infoList",list);//加入“infoList”数据模型
       return modelAndView;
   }
    @GetMapping("/header")
    public ModelAndView testHeaderView(){
        return new ModelAndView("header");
    }

   //以下是MVC交互

    //一、全站检索功能
    /**
     * 普通检索页面
     * @return
     */
   @GetMapping("/generalSearch")
    public ModelAndView genSearchView(){
       return new ModelAndView("noretrieval");
   }

    /**
     * 高级检索页面
     * @return
     */
    @GetMapping("/advancedSearch")
    public ModelAndView advSearchView(){
        return new ModelAndView("susearch");
    }

    /**
     * 检索结果详情
     * @param infoId
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView searchResultView(String infoId){
        return new ModelAndView("");
    }

    //二、信息分类展示功能

    /**
     * 1.就业信息首页
     * @return
     */
    @GetMapping("/jyxx")
    public ModelAndView jyxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("jyxx","infoList",list);
    }

    /**
     * 1.1 就业信息-实习信息
     * @return
     */
    @GetMapping("/sxxx")
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
        return new ModelAndView("jyxxsxxx","infoList",list);
    }

    /**
     * 1.2 就业信息-选调信息
     * @return
     */
    @GetMapping("/xdxx")
    public ModelAndView xdxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","xdxx",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("jyxxxdxx","infoList",list);
    }

    /**
     * 1.3 就业信息-招聘会信息
     * @return
     */
    @GetMapping("/zphxx")
    public ModelAndView zphxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","zph",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("jyxxzph","infoList",list);
    }

    /**
     * 1.4 就业信息-往年就业信息
     * @return
     */
    @GetMapping("/wnjyxx")
    public ModelAndView wnjyxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("job","wnjy",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("jyxxjysj","infoList",list);
    }

    /**
     * 2.通知公告首页
     * @return
     */
    @GetMapping("/tzgg")
    public ModelAndView tzggView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("tzgg","infoList",list);
    }

    /**
     * 2.1 通知公告-科研项目
     * @return
     */
    @GetMapping("/kyxm")
    public ModelAndView kyxmView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","kyxm",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("tzggkyxm","infoList",list);
    }

    /**
     * 2.2 通知公告-竞赛比赛
     * @return
     */
    @GetMapping("/jsbs")
    public ModelAndView jsbsView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","jsbs",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("tzggjstz","infoList",list);
    }

    /**
     * 2.3 通知公告-讲座通知
     * @return
     */
    @GetMapping("/jztz")
    public ModelAndView jztzView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","jztz",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("tzggjztz","infoList",list);
    }

    /**
     * 2.4 通知公告-会议通知
     * @return
     */
    @GetMapping("/hytz")
    public ModelAndView hytzView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("notice","hytz",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("tzgghytz","infoList",list);
    }

    /**
     * 3.政策制度首页
     * @return
     */
    @GetMapping("/zczd")
    public ModelAndView zczdView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("zczd","infoList",list);
    }

    /**
     * 3.1 政策制度-保研政策
     * @return
     */
    @GetMapping("/byzc")
    public ModelAndView byzcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","byzc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("zczdbyzc","infoList",list);
    }

    /**
     * 3.2 政策制度-招生政策
     * @return
     */
    @GetMapping("/zszc")
    public ModelAndView zszcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","zszc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("zczdzszc","infoList",list);
    }

    /**
     * 3.3 政策制度-培养政策
     * @return
     */
    @GetMapping("/pyzc")
    public ModelAndView pyzcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","pyzc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("zczdpyzc","infoList",list);
    }

    /**
     * 3.4 政策制度-其它政策
     * @return
     */
    @GetMapping("/qtzc")
    public ModelAndView qtzcView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("policy","atzc",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("zczdqtzc","infoList",list);
    }

    /**
     * 4.其它信息
     * @return
     */
    @GetMapping("/qtxx")
    public ModelAndView qtxxView(@RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationService.show("other","all",pageable);
        List<Information> list=new ArrayList<>();
        for(Information information:page){
            list.add(information);
        }
        return new ModelAndView("qtxx","infoList",list);
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
     * @param formulation
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/adSearch")
    public ResponseEntity<Response> advSearchResult(
            @RequestParam(value = "title",required = false,defaultValue = "")String formulation,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=null;
        try {
            page = informationService.advancedSearch(formulation,pageable);
        }catch (Exception e){
            return ResponseEntity.status((500)).body(new Response(false, e.getMessage()));
        }
        String list = JSONArray.fromObject(page).toString();
        return ResponseEntity.status(200).body(new Response(true,"查询成功！",list));

    }



}
