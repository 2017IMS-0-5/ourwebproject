package com.example.webproject.lxr;

import com.example.webproject.entity.Information;
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
        System.out.println("添加成功");
    }
    @Test
    void updatePassword(){//根据id查询用户并修改密码
        Optional<User> user=userService.getUserById((long) 3);
        System.out.println(user.toString());
        System.out.println("查询完毕");
        user.get().setPassword("990204");
        System.out.println(userService.saveOrUpdateUser(user.get()).toString());
        System.out.println("修改完毕");

    }
    @Test
    void selectUserByName(){//根据用户名分页查询
        Pageable pageable= PageRequest.of(0,20);
        Page<User> page=userService.listUsersByNameLike("李歆然", (Pageable) pageable);
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

}
