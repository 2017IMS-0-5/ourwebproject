package com.example.webproject.entity;

public class Major {
    private Long id;
    private String name;

    public Major(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major(Long id, String name){
        this.id=id;
        this.name=name;
    }
}
