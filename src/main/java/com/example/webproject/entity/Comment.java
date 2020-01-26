package com.example.webproject.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//主键
    private String userAccount;//用户学工号
    @Column(nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp createTime;//评论创建时间
    private String content;//评论内容

    public Comment(){
    }

    public Comment(String userAccount, String content) {
        this.userAccount=userAccount;
        this.content=content;
    }

    public long getId() {
        return id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }

}
