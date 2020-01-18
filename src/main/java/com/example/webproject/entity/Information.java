package com.example.webproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;

@Document(indexName = "information",type = "information")
public class Information {

    @Id//主键
    private String id;
    @Field(type= FieldType.Text)
    private String field;//一级标题
    @Field(type= FieldType.Text)
    private String subject;//二级标题
    @Field(type= FieldType.Text)
    private String author;//发布者
    @Field(type = FieldType.Text,fielddata = true)
    private String labels;//标签
    @Field(type= FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_smart")
    private String title;//文章标题
    @Field(type= FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_smart")
    private String content;//内容
    @Field(type = FieldType.Date,index = false)
    private Timestamp createTime;//创建时间
    @Field(type = FieldType.Integer,index = false)
    private Integer readSize=0;//阅读量
    @Field(type = FieldType.Text,fielddata = true)
    private String relation;//附件地址

    protected Information(){}

    public Information(String field, String subject, String author, String labels, String title,
                       String content, Integer readSize, Timestamp createTime, String relation) {
        this.field = field;
        this.subject = subject;
        this.author = author;
        this.labels = labels;
        this.title = title;
        this.content = content;
        this.readSize = readSize;
        this.createTime = createTime;
        this.relation=relation;
    }

    public Information(Information information){
        this.field = information.getField();
        this.subject = information.getSubject();
        this.author = information.getAuthor();
        this.labels = information.getLabels();
        this.title = information.getTitle();
        this.content = information.getContent();
        this.readSize = information.getReadSize();
        this.createTime = information.getCreateTime();
        this.relation=information.getRelation();
    }

    public void update(Information information){
        this.field = information.getField();
        this.subject = information.getSubject();
        this.author = information.getAuthor();
        this.labels = information.getLabels();
        this.title = information.getTitle();
        this.content = information.getContent();
        this.readSize = information.getReadSize();
        this.createTime = information.getCreateTime();
        this.relation=information.getRelation();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString(){
        return String.format(
                "Information[id='%s',field='%s',subject='%s',author=='%s',title='%s',content='%s',readSize='%s']",
                id,field,subject,author,title,content,readSize
        );
    }
}
