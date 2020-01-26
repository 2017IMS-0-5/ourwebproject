package com.example.webproject.service;

import com.example.webproject.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    /**
     * 根据id获取 Comment
     * @param id
     * @return
     */
    Optional<Comment> getCommentById(Long id);

    /**
     * 删除评论
     * @param id
     * @return
     */
    void removeComment(Long id);

    /**
     * 根据用户学工号获取 Comment
     * @param userAccount
     * @param pageable
     * @return
     */
    Page<Comment> showUserComments(String userAccount, Pageable pageable);

    /**
     * 增加评论
     * @return
     */
    Comment addComment(Comment comment);

}