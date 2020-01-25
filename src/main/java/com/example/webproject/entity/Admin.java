package com.example.webproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import javax.validation.constraints.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//@Document(indexName="admin",type="admin")
public class Admin {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id

    @NotEmpty(message = "管理员名字不能为空")
    private String adminName;//管理员姓名

    @NotEmpty(message = "密码不能为空")
    private String password;//密码

    @NotEmpty(message = "账号不能为空")
    private String account;//账号-学号或工号

    @NotEmpty(message = "角色不能为空")
    private String role;//只有superManager，manager两种

    public Admin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Admin(Long id, String adminName, String password, String account, String role) {
        this.id = id;
        this.adminName = adminName;
        this.password = password;
        this.account = account;
        this.role = role;
    }

    public Admin(Admin admin) {
        this.id = admin.getId();
        this.adminName = admin.getAdminName();
        this.password = admin.getPassword();
        this.account = admin.getAccount();
        this.role = admin.getRole();
    }

    public void update(Admin admin) {
        this.id = admin.getId();
        this.adminName = admin.getAdminName();
        this.password = admin.getPassword();
        this.account = admin.getAccount();
        this.role = admin.getRole();
    }

    @Override
    public String toString(){
        return String.format(
                "Admin[id='%d',adminName='%s',password='%s',account='%s',role='%s']",
                id,adminName,password,account,role
        );
    }
}

