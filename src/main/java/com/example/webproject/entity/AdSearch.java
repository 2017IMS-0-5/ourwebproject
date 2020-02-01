package com.example.webproject.entity;

import java.sql.Timestamp;

public class AdSearch {
    private String title="";
    private String label="";
    private String content="";
    private String author="";
    private String field="";
    private String subject="";
    private String from;
    private String to;

    public AdSearch(){}

    public AdSearch(String title, String label, String content, String author, String field, String subject, String from, String to) {
        this.title = title;
        this.label = label;
        this.content = content;
        this.author = author;
        this.field = field;
        this.subject = subject;
        this.from = from;
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "AdSearch{" +
                "title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", field='" + field + '\'' +
                ", subject='" + subject + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
