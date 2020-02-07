package com.example.webproject.repository;

import com.example.webproject.entity.UserFavor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFavorRepository extends JpaRepository<UserFavor,Long> {
    //根据用户学工号查找用户收藏信息
    Page<UserFavor> findByUserAccount(String userAccount, Pageable pageable);
    Boolean existsByUserAccountAndInfold(String userAccount, String infold);
}