package com.example.webproject.zmx;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.sql.Timestamp;

@SpringBootTest
public class TestInformationService {
    @Autowired
    private InformationRepository informationRepository;

    @Test
    void saveRepositoryData(){
        informationRepository.deleteAll();
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
    void testInformationRepositoryFindByTitleContainingOrSummaryContainingOrContentContaining() {
         Pageable pageable= PageRequest.of(0,20);
         String title="";
         String content="down";
         Page<Information> page=informationRepository.findByTitleContainingOrContentContaining(title,content,pageable);
         System.out.println("============start 1");
         for(Information information:page){
         System.out.println(information.toString());
         }
         System.out.println("============end 1");


    }

}
