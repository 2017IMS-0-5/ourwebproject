package com.example.webproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String account;
    private String gender;
    private String grade;
    private String major;
    private int role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAccount() {
        return account;
    }

    public String getGender() {
        return gender;
    }

    public String getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    public int getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setRole(int role) {
        this.role = role;
    }
    public User(String name,String email,String password,String account,String gender,String grade,String major,int role){
        this.name=name;
        this.email=email;
        this.password=password;
        this.account=account;
        this.gender=gender;
        this.grade=grade;
        this.major=major;
        this.role=role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", role=" + role +
                '}';
    }
}