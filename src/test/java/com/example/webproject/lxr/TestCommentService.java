package com.example.webproject.lxr;

import com.example.webproject.entity.Comment;
import com.example.webproject.entity.User;
import com.example.webproject.repository.CommentRepository;
import com.example.webproject.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
@SpringBootTest
public class TestCommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;
    @Test
    void addComment(){//添加评论
        commentService.addComment(new Comment("201711260115","美赛求组队"));
        System.out.println("添加成功");
    }
    @Test
    void showComment(){//根据用户账号分页查询
        Pageable pageable= PageRequest.of(0,20);
        Page<Comment> page=commentService.showUserComments("201711260115", (Pageable) pageable);
        for(Comment comment:page){
            System.out.println(comment.toString());
        }
        System.out.println("显示完毕");
    }
    @Test
    void deleteComment(){//删除评论
        commentService.removeComment((long) 1);
        System.out.println("删除成功");
    }
}
