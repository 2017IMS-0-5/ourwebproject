package com.example.webproject.repository;

import com.example.webproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    //根据用户名分页查询用户列表

    List<User> findAll();

}

