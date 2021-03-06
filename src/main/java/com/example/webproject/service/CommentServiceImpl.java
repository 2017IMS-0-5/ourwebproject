package com.example.webproject.service;

import com.example.webproject.entity.Comment;
import com.example.webproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> showUserComments(String userAccount, Pageable pageable){
        return commentRepository.findByUserAccount(userAccount,pageable);
    }

    @Transactional
    @Override
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getAllCommentByTime(Pageable pageable){
        return commentRepository.findAllByOrderByCreateTimeDesc(pageable);
    }

    @Override
    public Page<Comment> getByDate(Date date, Pageable pageable){
        return commentRepository.findByDate(date,pageable);
    }

    @Override
    public Page<Comment> getByDateAndUserAccount(Date date, String userAccount, Pageable pageable){
        return commentRepository.findByDateAndUserAccount(date,userAccount,pageable);
    }

}
