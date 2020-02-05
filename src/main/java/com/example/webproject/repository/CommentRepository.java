package com.example.webproject.repository;

import com.example.webproject.entity.Comment;
import com.example.webproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Timestamp;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 根据用户账号分页查询评论列表
     * @param userAccount
     * @param pageable
     * @return
     */
    Page<Comment> findByUserAccount(String userAccount,Pageable pageable);

    /**
     *根据日期分页查询评论列表
     * @param date
     * @return
     */
    @Query(name="findByDate",nativeQuery = true,value =
            "select * from comment where left(createTime,10)=:date")
    Page<Comment> findByDate(@Param("date") Date date,Pageable pageable);
}
