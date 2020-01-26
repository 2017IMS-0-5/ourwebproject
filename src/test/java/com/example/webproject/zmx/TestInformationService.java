package com.example.webproject.zmx;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import com.example.webproject.service.InformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TestInformationService {
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private InformationService informationService;

    @Test
    void saveRepositoryData(){
       // informationRepository.deleteAll();
        informationRepository.save(new Information("job","sxxx","郑明煊","字节跳动 程序员","字节跳动招聘程序员",
                "【职位描述】\n" +
                        "1、维护、拓展公司招聘渠道，更新招聘信息；\n" +
                        "2、根据JD筛选、推荐简历，协调面试官、候选人沟通；\n" +
                        "3、与业务部门保持有效沟通，跟进招聘结果和流程反馈；\n" +
                        "4、执行人才搜索和寻访，推进招聘计划；\n" +
                        "5、量化招聘过程数据，找到招聘问题并实时解决。\n" +
                        "【职位要求】\n" +
                        "1、2021年及以后毕业本科生/研究生，或2020已保研，专业不限；\n" +
                        "2、积极、主动、耐心、踏实、高效、善于沟通；\n" +
                        "3、具有较强自主学习能力；\n" +
                        "4、能够连续实习3个月及以上，每周出勤4天及以上者优先，能尽快入职者优先。\n" +
                        "【简历投递通道】\n" +
                        "wangyuxuan.12345678@bytedance.com\n" +
                        "邮件标题请命名为姓名-学校-毕业年份-每周实习天数",
 0,new Timestamp(System.currentTimeMillis()),""));


    }

    @Test
    void serviceSave(){//测试新增功能
        String info=informationService.saveInfo(new Information("notice","jztz","郑明煊","WEB 用户画像","新闻推荐任务中用户画像的构建和使用",
                "讲座题目：新闻推荐任务中用户画像的构建和使用\n" +
                        "讲座人：尹珺\n" +
                        "时间：2019年11月9日 15：00-17：00\n" +
                        "讲座地点：主楼A区509\n" +
                        " \n" +
                        "讲座人简介：尹珺，博士毕业于北京大学信息科学技术学院，现工作于腾讯北京AI平台部个性化推荐中心，主要做新闻推荐的图文和视频召回相关工作。专注于基于深度模型方法进行用户兴趣建模。\n" +
                        "\n" +
                        "讲座内容简介：新闻推荐系统不需要用户显式提交任何查询和兴趣偏好，通过自动化算法来进行“千人千面”的内容推送。这其中的一个核心技术是用户画像构建。学术界和工业界提出过很多技术手段来构建用户画像，结合实际任务，本次主要介绍用户画像构建的基本方法，包括显式用户画像和隐式用户画像。",
                0,new Timestamp(System.currentTimeMillis()),"")).toString();
        System.out.println(info);
        System.out.println("插入完毕");
    }

    @Test
    void serviceFindByIdANDUpdate(){//测试根据ID查询功能以及更新功能
        Optional<Information> information=informationService.selectInfoById("fvKKxm8BTa4F5iFyOyDz");
        System.out.println(information.toString());
        System.out.println("查询完毕");
       //information.get().setTitle("新闻推荐任务中用户画像的构建和使用--以QQ看点为例");
        //System.out.println(informationService.updateInfo(information.get()).toString());
        //System.out.println("修改完毕");
    }

    @Test
    void testGeneralSearch() {//测试模糊查询
         Pageable pageable= PageRequest.of(0,20);
         String keyword="";
         Page<Information> page=informationService.generalSearch(keyword,pageable);
         System.out.println("============start");
         for(Information information:page){
         System.out.println(information.toString());
         }
         System.out.println("============end");
    }

    @Test
    void testShow() {//测试分类显示
        Pageable pageable= PageRequest.of(0,20);
        String field="job";
        String subject="sxxx";
        Page<Information> page=informationService.show(field,subject,pageable);
        System.out.println("============start");
        for(Information information:page){
            System.out.println(information.toString());
        }
        System.out.println("============end");
    }
    @Test
    void testSelectInformationListByInfoIdList(){//测试根据ID序列查询信息//注：不同DB同一篇Information的ID可能不同，ID可能需要自己改一下
        List<String> infoIdList=new ArrayList<>();
        infoIdList.add("ffI6xm8BTa4F5iFyAyAA");
        infoIdList.add("sVBp0m8BjXCVwJ6PP9yX");
        infoIdList.add("sFBp0m8BjXCVwJ6PFdyQ");
        infoIdList.add("fvKKxm8BTa4F5iFyOyDz");
        System.out.println(informationService.selectByIdList(infoIdList).toString());
        System.out.println("查询完毕");
    }

    @Test
    void testSeletInformationListByLabel(){
        Pageable pageable= PageRequest.of(0,20);
        String label=" 程序员";
        Page<Information> page=informationService.selectByLabel(label,pageable);
        System.out.println("============start");
        for(Information information:page){
            System.out.println(information.toString());
        }
        System.out.println("============end");
        System.out.println("查询完毕");
    }

}
