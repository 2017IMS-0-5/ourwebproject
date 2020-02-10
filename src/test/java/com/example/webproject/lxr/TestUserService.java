package com.example.webproject.lxr;

import com.example.webproject.entity.User;
import com.example.webproject.repository.UserRepository;
import com.example.webproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Test
    void addUser(){//添加新用户
        userService.registerUser(new User("李歆然","201711260115@mail.bnu.edu.cn","260115","201711260115","女","2017","信管",1));
        userService.registerUser(new User("孙静彤","201711260111@mail.bnu.edu.cn","260111","201711260111","女","2017","信管",1));
        userService.registerUser(new User("陈琛妍","201711260101@mail.bnu.edu.cn","260101","201711260101","女","2017","信管",1));
        userService.registerUser(new User("强纾旖","201711260103@mail.bnu.edu.cn","260103","201711260103","女","2017","管科",1));
        userService.registerUser(new User("张三","201611260101@mail.bnu.edu.cn","260101","201611260101","男","2016","管科",1));
        userService.registerUser(new User("李四","201611260150@mail.bnu.edu.cn","260150","201611260150","男","2016","公管",1));
        userService.registerUser(new User("王五","201811260166@mail.bnu.edu.cn","260166","201811260166","男","2018","人管",1));
        userService.registerUser(new User("赵六","201911260120@mail.bnu.edu.cn","260120","201911260120","女","2019","人管大类",1));
        userService.registerUser(new User("钱七","201911260108@mail.bnu.edu.cn","260108","201911260108","男","2019","人管大类",1));
        userService.registerUser(new User("刘八","201911260155@mail.bnu.edu.cn","260155","201911260155","女","2019","管工大类",1));
        userService.registerUser(new User("张同学","201711260132@mail.bnu.edu.cn","260132","201711260132","女","2017","人管",1));
        userService.registerUser(new User("孙同学","201811260200@mail.bnu.edu.cn","260200","201811260200","男","2018","公管",1));
        userService.registerUser(new User("李同学","201911260254@mail.bnu.edu.cn","260254","201911260254","女","2019","人管大类",1));
        userService.registerUser(new User("杨同学","201611260233@mail.bnu.edu.cn","260233","201611260233","女","2016","人管",1));
        userService.registerUser(new User("王同学","201711260119@mail.bnu.edu.cn","260119","201711260119","男","2017","管科",1));
        userService.registerUser(new User("张老师","zls@bnu.edu.cn","260001","11260001","女","","行政管理系",2));
        userService.registerUser(new User("李老师","lxs@bnu.edu.cn","260002","11260002","男","","信息管理系",2));
        userService.registerUser(new User("王老师","wls@bnu.edu.cn","260003","11260003","女","","组织与人力资源系",2));
        userService.registerUser(new User("孙老师","sls@bnu.edu.cn","260004","11260004","女","","组织与人力资源系",2));
        userService.registerUser(new User("杨老师","yls@bnu.edu.cn","260005","11260005","男","","信息管理系",2));
        System.out.println("添加成功");
    }
    @Test
    void updatePassword(){//根据id查询用户并修改密码
        Optional<User> user=userService.getUserById((long) 1);
        System.out.println(user.toString());
        System.out.println("查询完毕");
        user.get().setPassword("990204");
        System.out.println(userService.saveOrUpdateUser(user.get()).toString());
        System.out.println("修改完毕");

    }
    @Test
    void selectUserByName(){//根据用户名分页查询
        Pageable pageable= PageRequest.of(0,20);
        Page<User> page=userService.listUsersByNameLike("孙静彤", (Pageable) pageable);
        for(User user:page){
            System.out.println(user.toString());
        }
        System.out.println("查询完毕");
    }
    @Test
    void deleteUser(){//删除用户
        userService.removeUser((long) 2);
        System.out.println("删除成功");
    }

    @Test
    void login(){//登录
        User user=userService.login("201711260115","990204");
        if(user!=null){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }
    }

    @Test
    void count(){
        int i = userService.countAllUsers();
        System.out.println("用户总人数为"+i);
    }

}
