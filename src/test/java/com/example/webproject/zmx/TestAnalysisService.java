package com.example.webproject.zmx;

import com.example.webproject.entity.AdSearch;
import com.example.webproject.entity.Information;
import com.example.webproject.service.AnalysisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestAnalysisService {
    @Autowired
    private AnalysisService analysisService;

    @Test
    void testAnaData(){
        List<Integer> numList=analysisService.getInfoSizeByField();
        List<Integer> rSizeList=analysisService.getReadSizeByField();

        System.out.println("   job notice policy other");
        System.out.println("number:"+numList.toString());
        System.out.println("size:"+rSizeList.toString());


        List<Integer> hotList=new ArrayList<>();
        for(int i=0;i<4;i++){
            hotList.add(rSizeList.get(i)/numList.get(i));
        }
        System.out.println("average:"+hotList.toString());

    }

    @Test
    void testCountAllInfo(){
        System.out.println(analysisService.countAllInfo());
    }
    
}
