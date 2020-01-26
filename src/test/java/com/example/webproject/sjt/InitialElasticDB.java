package com.example.webproject.sjt;

import com.example.webproject.entity.Information;
import com.example.webproject.service.InformationService;
import com.example.webproject.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class InitialElasticDB {
    @Autowired
    private InformationService informationService;
    @Test
    void addJobData(){
        // informationRepository.deleteAll();
        informationService.saveInfo(new Information("job","sxxx","郑明煊","中诚 业务","中诚信托北京总部业务一部实习生",
                "中诚信托北京总部业务一部实习生招聘\n" +
                        "（一）职位名称：业务部门实习生    \n" +
                        "工作地点：北京市东城区安贞门    \n" +
                        "招聘人数：1人    \n" +
                        "实习补贴：每天100元，食堂提供免费早午餐。    \n" +
                        "（二） 岗位职责      \n" +
                        "1、    在部门负责人指导下，配合业务团队工作，开展项目调研论证工作，撰写项目执行方案；    \n" +
                        "2、    进行项目的遴选、谈判和产品设计，统筹规划备选项目的尽职调查，设计信托方案框架并撰写报告；    \n" +
                        "3、    按公司和监管部门规定，实施内外部报批程序，协助完成信托计划推介、路演，推动信托计划发行成立；    \n" +
                        "4、    根据项目投资合同文本约定的条款，实施项目管理，跟踪项目进展。   \n" +
                        "（三） 岗位要求    \n" +
                        "1、    为人诚信，基本素质好，头脑灵活，勤奋好学，愿意在信托业成就一番事业；  \n" +
                        "2、    本科及以上学历，专业财务、会计、金融、法律。     \n" +
                        " 年后入职即可，感兴趣同学简历发给我可以。",
                0,new Timestamp(System.currentTimeMillis()),""));
        informationService.saveInfo(new Information("job","sxxx","郑明煊","百度 运营 程序员","百度运营实习生",
                "【百度运营实习生】（急招，组内直推，尽快到岗优先）\n" +
                        "岗位职责：\n" +
                        "·  协助自动驾驶相关产品文档的撰写和归类；\n" +
                        "·  自主运营自动驾驶开发者社区；\n" +
                        "·  进行社区相关数据的收集与整理；\n" +
                        "·  协助校园开发者生态的扩展，了解校企活动运作方式优先；\n" +
                        "·  负责协调企业内部相关事宜，如会议安排、合同流程审批等。\n" +
                        "职责要求：\n" +
                        "·  积极主动，认真细心，具有较强的适应和沟通能力；\n" +
                        "·  对自动驾驶行业有所了解；\n" +
                        "·  良好的文案撰写能力；\n" +
                        "·  良好的逻辑思维能力和沟通能力；\n" +
                        "·  至少实习三个月，每周实习5天。\n" +
                        "加分项：\n" +
                        "· 有很强的学习能力和和责任心优先；\n" +
                        "· 计算机、电子、车辆工程相关专业优先；\n" +
                        "· 自动驾驶爱好者或有技术背景者优先；\n" +
                        "· 尽快到岗优先\n" +
                        "你将获得：\n" +
                        "·  和Apollo自动驾驶工程师交流的机会；\n" +
                        "·  和高校自动驾驶领域教师交流的机会；\n" +
                        "·  自身综合能力的提升。\n" +
                        "待遇：\n" +
                        "· 150/day，免费水果下午茶\n" +
                        "工作地点：\n" +
                        "· 百度科技园\n" +
                        "联系方式：\n" +
                        "请发送简历至15233551837@163.com\n" +
                        "格式：「运营实习生+最快到岗时间+一周x天+持续x个月+学校+姓名」",
                0,new Timestamp(System.currentTimeMillis()),""));

    }
}

