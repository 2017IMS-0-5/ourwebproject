package com.example.webproject.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class UserFavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//主键
    private String userAccount;//用户学工号
    @Column(nullable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp createTime;//收藏时间
    private String infold;//信息编号

    public long getId() {
        return id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public String getInfold() {
        return infold;
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

    public void setInfold(String infold) {
        this.infold = infold;
    }

    public UserFavor() {
    }

    public UserFavor(String userAccount, String infold) {
        this.userAccount=userAccount;
        this.infold=infold;
    }

    @Override
    public String toString() {
        return "UserFavor{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", createTime=" + createTime +
                ", infold='" + infold + '\'' +
                '}';
    }
}
