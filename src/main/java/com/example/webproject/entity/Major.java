package com.example.webproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Major {
    @Id
    @GeneratedValue
    private long id;
    private String majorname;

    public Major() {
    }

    public Major(String majorname) {
        this.majorname = majorname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }
}
