package com.example.webproject.service;

import com.example.webproject.entity.Information;
//import com.example.webproject.entity.User;
//import com.example.webproject.entity.Comment;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface AdminService {

    /**
     * 按照用户角色和姓名信息展示
     * @param role
     * @param name
     * @return
     */
//    Optional<User> userShowByRoleAndName(int role, String name);

    /**
     * 按照用户角色和年级信息展示
     * @param role
     * @param grade
     * @return
     */
//    Optional<User> userShowByRoleAndGrade(int role, String grade);

    /**
     * 按照用户角色和专业信息展示
     * @param role
     * @param major
     * @return
     */
//    Optional<User> userShowByRoleAndMajor(int role, String major);

    /**
     * 按照用户角色和账号信息展示
     * @param role
     * @param account
     * @return
     */
//    Optional<User> userShowByRoleAndAccount(int role, String account);

    /**
     * 按照用户角色和性别信息展示
     * @param role
     * @param gender
     * @return
     */
//    Optional<User> userShowByRoleAndGender(int role, String gender);

    /**
     * 按照用户角色和邮箱信息展示
     * @param role
     * @param email
     * @return
     */
//    Optional<User> userShowByRoleAndEmail(int role, String email);

    /**
     * 按照信息类型（一级标题）和二级标题展示
     * @param field
     * @param subject
     * @return
     */
    Optional<Information> infoShowByFieldAndSubject(String field, String subject);

    /**
     * 按照信息类型（一级标题）和标题展示
     * @param field
     * @param title
     * @return
     */
    Optional<Information> infoShowByFieldAndTitle(String field, String title);

    /**
     * 按照信息类型（一级标题）和作者展示
     * @param field
     * @param author
     * @return
     */
    Optional<Information> infoShowByFieldAndAuthor(String field, String author);

    /**
     * 按照信息类型（一级标题）和创建时间展示
     * @param field
     * @param createTime
     * @return
     */
    Optional<Information> infoShowByFieldAndCreateTime(String field, Date createTime);

    /**
     * 按照信息类型（一级标题）和标签展示
     * @param field
     * @param labels
     * @return
     */
    Optional<Information> infoShowByFieldAndLabels(String field, String labels);

    /**
     * 按照信息类型（一级标题）和附件地址展示
     * @param field
     * @param relation
     * @return
     */
    Optional<Information> infoShowByFieldAndRelation(String field, String relation);

    /**
     * 按照留言账号和时间展示
     * @param userAccount
     * @param createTime
     * @return
     */
//    Optional<Comment> commShowByUserAccountAndCreateTime(String userAccount, Date createTime);

    //消息数量返回
    Long[] infoTotalStatistics();

    //一定时间段消息数量返回
    Long[] infoPartStatistics(Date starttime, Date endtime);

    //标签数量返回
   // List<Admin> labelStatistics();

    Long[] adminRoleStatistics();

    //用户角色数量返回
//    Optional<User> userRoleStatistics();

    //用户专业数量返回
//    Optional<User> userMajorStatistics();

    //管理员角色数量返回
//    Optional<Admin> adminRoleStatistics();

}
