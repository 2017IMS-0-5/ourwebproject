package com.example.webproject.entity;

public class LabelVO {
    private String name;
    private long count;

    public  LabelVO(){}
    public LabelVO(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
