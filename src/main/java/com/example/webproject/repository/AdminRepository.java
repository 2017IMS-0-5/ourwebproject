package com.example.webproject.repository;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.Information;
import com.example.webproject.entity.LabelVO;
//import com.example.webproject.entity.User;
//import com.example.webproject.entity.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface AdminRepository extends JpaRepository<Admin,String>{

    /**
     * where role=role and grade=grade;
     * @param role
     * @param grade
     * @return
     */
//    Optional<User> findByRoleAndGrade(int role,String grade);

    /**
     * where role=role and major=major;
     * @param role
     * @param major
     * @return
     */
//    Optional<User> findByRoleAndMajor(int role,String major);

    /**
     * where role=role and account=account;
     * @param role
     * @param account
     * @return
     */
//    Optional<User> findByRoleAndAccount(int role,String account);

    /**
     * where role=role and name=name;
     * @param role
     * @param name
     * @return
     */
//    Optional<User> findByRoleAndName(int role,String name);

    /**
     * where role=role and gender=gender;
     * @param role
     * @param gender
     * @return
     */
//    Optional<User> findByRoleAndGender(int role,String gender);

    /**
     * where role=role and email=email;
     * @param role
     * @param email
     * @return
     */
//    Optional<User> findByRoleAndEmail(int role,String email);

    /**
     * where field=field and subject=subject;
     * @param field
     * @param subject
     * @return
     */
    Optional<Information> findByFieldAndSubject(String field,String subject);

    /**
     * where field=field and title=title;
     * @param field
     * @param title
     * @return
     */
    Optional<Information> findByFieldAndTitle(String field,String title);

    /**
     * where field=field and author=author;
     * @param field
     * @param author
     * @return
     */
    Optional<Information> findByFieldAndAuthor(String field,String author);

    /**
     * where field=field and createTime=createTime;
     * @param field
     * @param createTime
     * @return
     */
    Optional<Information> findByFieldAndCreateTime(String field,Date createTime);

    /**
     * where field=field and labels=labels;
     * @param field
     * @param labels
     * @return
     */
    Optional<Information> findByFieldAndLabelsContaining(String field,String labels);

    /**
     * where field=field and relation=relation;
     * @param field
     * @param relation
     * @return
     */
    Optional<Information> findByFieldAndRelation(String field,String relation);

    /**
     * where userAccount=userAccount and createTime=createTime;
     * @param userAccount
     * @param createTime
     * @return
     */
//    Optional<Comment> findByUserAccountAndCreateTime(String userAccount,Date createTime);

    //返回各种信息的数量
    @Query(value="SELECT count(id) FROM informantion i WHERE i.field= ?1",nativeQuery=true)
    Long getTotal(String field);

    //返回各种信息在一段时间内上传的数量
    @Query(value="SELECT count(id) FROM informantion i WHERE i.field= ?1 and i.createTime between ?2 and ?3",nativeQuery=true)
    Long getTotalTime(String field,Date starttime,Date endtime);

    //返回各种标签的使用数量
    @Query(value="select l.count from labelVO l where l.name= ?1",nativeQuery=true)
    Long getLabelAccount(String name);

    //返回user各种角色的数量
    @Query(value="SELECT count(id) FROM user u WHERE u.role= ?1",nativeQuery=true)
    Long getUserRole(int role);

    //返回user各种专业的数量
    @Query(value="SELECT count(id) FROM user u WHERE u.major= ?1",nativeQuery=true)
    Long getUserMajor(String major);

    //返回admin各种角色的数量
    @Query(value="SELECT count(id) FROM admin a WHERE a.role= ?1",nativeQuery=true)
    Long getAdminRole(String role);
}
