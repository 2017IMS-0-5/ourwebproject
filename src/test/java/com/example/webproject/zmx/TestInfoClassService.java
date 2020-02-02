package com.example.webproject.zmx;

import com.example.webproject.service.InfoClassService;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestInfoClassService {
    @Autowired
    private InfoClassService infoClassService;

    @Test
    void testShowSubList(){
        System.out.println(infoClassService.selectByField("notice").toString());
    }

}
