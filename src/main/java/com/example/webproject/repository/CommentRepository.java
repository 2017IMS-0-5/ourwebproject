package com.example.webproject.repository;

import com.example.webproject.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 根据用户姓名分页查询用户列表
     * @param userAccount
     * @param pageable
     * @return
     */
    Page<Comment> findByUserAccount(String userAccount,Pageable pageable);
}
