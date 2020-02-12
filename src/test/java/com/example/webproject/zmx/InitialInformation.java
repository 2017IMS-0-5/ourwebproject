package com.example.webproject.zmx;

import com.example.webproject.entity.InfoClass;
import com.example.webproject.repository.InfoClassRepository;
import com.example.webproject.service.InfoClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InitialInformation {
    @Autowired
    private InfoClassService infoClassService;
    @Autowired
    private InfoClassRepository infoClassRepository;

    @Test
    void testSave(){
        List<InfoClass> infoClassList=new ArrayList<>();
        System.out.println(infoClassService.saveOrUpdate(new InfoClass("other","其它","other")));
    }
    @Test
    void initialInfoClass(){
        infoClassRepository.deleteAll();
        List<InfoClass> infoClassList=new ArrayList<>();
        infoClassList.add(new InfoClass("job","实习信息","sxxx"));
        infoClassList.add(new InfoClass("job","选调信息","xdxx"));
        infoClassList.add(new InfoClass("job","招聘会信息","zphxx"));
        infoClassList.add(new InfoClass("job","往届就业信息","wjjyxx"));
        infoClassList.add(new InfoClass("policy","保研政策","byzc"));
        infoClassList.add(new InfoClass("policy","招生政策","zszc"));
        infoClassList.add(new InfoClass("policy","培养政策","pyzc"));
        infoClassList.add(new InfoClass("policy","其它政策","qtzc"));
        infoClassList.add(new InfoClass("notice","科研项目通知","kyxm"));
        infoClassList.add(new InfoClass("notice","竞赛比赛通知","jsbs"));
        infoClassList.add(new InfoClass("notice","讲座通知","jztz"));
        infoClassList.add(new InfoClass("notice","会议通知","hytz"));
        infoClassList.add(new InfoClass("other","其它信息","qtxx"));
        infoClassService.saveOrUpdateList(infoClassList);
    }
}
