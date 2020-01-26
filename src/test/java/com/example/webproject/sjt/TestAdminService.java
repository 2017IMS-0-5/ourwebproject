package com.example.webproject.sjt;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.AdminRepository;
import com.example.webproject.service.AdminService;
import com.example.webproject.service.InformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@SpringBootTest
public class TestAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    @Test
    void testinfoShowByFieldAndSubject() {//测试按照一级标题和二级标题显示
        String field="job";
        String subject="sxxx";
        Optional<Information> info=adminService.infoShowByFieldAndSubject(field,subject);
        System.out.println("============start");
        System.out.println(info.toString());
        System.out.println("============end");
    }

    @Test
    void testinfoTotalStatistics() {//测试统计各类信息数据
        Long[] stati=adminService.infoTotalStatistics();
        System.out.println("============start");
        System.out.println(stati.toString());
        System.out.println("============end");
    }
}
