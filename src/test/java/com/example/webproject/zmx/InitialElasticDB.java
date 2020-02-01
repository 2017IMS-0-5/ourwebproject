package com.example.webproject.zmx;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import com.example.webproject.service.InformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class InitialElasticDB {
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private InformationService informationService;

    @Test
    void deleteAll(){
        informationRepository.deleteAll();
    }

    @Test
    void addJobData(){
        // informationRepository.deleteAll();
        informationRepository.save(new Information("job","sxxx","郑明煊","中诚 业务","中诚信托北京总部业务一部实习生",
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
        informationRepository.save(new Information("job","sxxx","郑明煊","百度 运营 程序员","百度运营实习生",
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
    void addNoticeData(){
        informationRepository.save(new Information("notice","jztz","郑明煊","WEB 用户画像","新闻推荐任务中用户画像的构建和使用",
                "讲座题目：新闻推荐任务中用户画像的构建和使用\n" +
                        "讲座人：尹珺\n" +
                        "时间：2019年11月9日 15：00-17：00\n" +
                        "讲座地点：主楼A区509\n" +
                        " \n" +
                        "讲座人简介：尹珺，博士毕业于北京大学信息科学技术学院，现工作于腾讯北京AI平台部个性化推荐中心，主要做新闻推荐的图文和视频召回相关工作。专注于基于深度模型方法进行用户兴趣建模。\n" +
                        "\n" +
                        "讲座内容简介：新闻推荐系统不需要用户显式提交任何查询和兴趣偏好，通过自动化算法来进行“千人千面”的内容推送。这其中的一个核心技术是用户画像构建。学术界和工业界提出过很多技术手段来构建用户画像，结合实际任务，本次主要介绍用户画像构建的基本方法，包括显式用户画像和隐式用户画像。",
                0,new Timestamp(System.currentTimeMillis()),""));
    }

    @Test
    void initialAll(){
        deleteAll();
        System.out.println("delete over!");
        addJobData();
        System.out.println("Job over!");
        addNoticeData();
        System.out.println("notice over!");
        System.out.println("insert over!");
    }
}
