package com.example.webproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//主键
    private String field;
    private String subject;
    private String subValue;

    public InfoClass(){}

    public InfoClass(String field, String subject, String subValue) {
        this.field = field;
        this.subject = subject;
        this.subValue = subValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubValue() {
        return subValue;
    }

    public void setSubValue(String subValue) {
        this.subValue = subValue;
    }

    @Override
    public String toString() {
        return "InfoClass{" +
                "id=" + id +
                ", field='" + field + '\'' +
                ", subject='" + subject + '\'' +
                ", subValue='" + subValue + '\'' +
                '}';
    }
}
