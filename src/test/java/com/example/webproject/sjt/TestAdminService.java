package com.example.webproject.sjt;

import com.example.webproject.entity.Admin;
import com.example.webproject.repository.AdminRepository;
import com.example.webproject.service.AdminService;
import com.example.webproject.service.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class TestAdminService {

    @Autowired
    private AdminService adminService;

    @Test
    void testSave(){
        Admin admin=new Admin("201711260225","123","孙静彤","manager");
        System.out.println(adminService.SaveNewAdmin(admin).toString());
    }

    @Test
    void testUpdate(){
        Admin admin=new Admin("201711260225","123","郑明煊","manager");
        admin.setId(1);
        System.out.println(adminService.UpdateAdmin(admin));
    }

    @Test
    void testSelectAll(){
        Pageable pageable= PageRequest.of(1,2);
        Page<Admin> page=adminService.selectAllAdmin(pageable);
        for(Admin admin:page){
            System.out.println(admin.toString());
        }
    }

    @Test
    void testDelete(){
        adminService.DeleteById(1);
        System.out.println("删除完毕");
    }

    @Test
    void contextLoads() {
    }

}
