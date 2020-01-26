package com.example.webproject.service;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.Information;
//import com.example.webproject.entity.User;
//import com.example.webproject.entity.Comment;
import com.example.webproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

//    @Override
//    public Optional<User> userShowByRoleAndName(int role, String name){ return adminRepository.findByRoleAndName(role,name);};

//    @Override
//    public Optional<User> userShowByRoleAndGrade(int role, String grade){ return adminRepository.findByRoleAndGrade(role,grade);};

//    @Override
//    public Optional<User> userShowByRoleAndMajor(int role, String major){ return adminRepository.findByRoleAndMajor(role,major);};

//    @Override
//    public Optional<User> userShowByRoleAndAccount(int role, String account){ return adminRepository.findByRoleAndAccount(role,account);};

//    @Override
//    public Optional<User> userShowByRoleAndGender(int role, String gender){ return adminRepository.findByRoleAndGender(role,gender);};

//    @Override
//    public Optional<User> userShowByRoleAndEmail(int role, String email){ return adminRepository.findByRoleAndEmail(role,email);};

    @Override
    public Optional<Information> infoShowByFieldAndSubject(String field, String subject){return adminRepository.findByFieldAndSubject(field,subject);};

    @Override
    public Optional<Information> infoShowByFieldAndTitle(String field, String title){return adminRepository.findByFieldAndTitle(field,title);};

    @Override
    public Optional<Information> infoShowByFieldAndAuthor(String field, String author){return adminRepository.findByFieldAndAuthor(field,author);};

    @Override
    public Optional<Information> infoShowByFieldAndCreateTime(String field, Date createTime){return adminRepository.findByFieldAndCreateTime(field,createTime);};

    @Override
    public Optional<Information> infoShowByFieldAndLabels(String field, String labels){return adminRepository.findByFieldAndLabelsContaining(field,labels);};

    @Override
    public Optional<Information> infoShowByFieldAndRelation(String field, String relation){return adminRepository.findByFieldAndRelation(field,relation);};

//    @Override
//    Optional<Comment> commShowByUserAccountAndCreateTime(String userAccount, Date createTime){ return adminRepository.findByUserAccountAndCreateTime(userAccount,createTime);};

    @Override
    public Long[] infoTotalStatistics(){
        Long tzgg_account;
        tzgg_account=adminRepository.getTotal("通知公告");
        Long jyxx_account;
        jyxx_account=adminRepository.getTotal("就业信息");
        Long zcgz_account;
        zcgz_account=adminRepository.getTotal("政策规章");
        Long qtxx_account;
        qtxx_account=adminRepository.getTotal("其他信息");
        Long[] a = new Long[0];
        a[0]=tzgg_account;
        a[1]=jyxx_account;
        a[2]=zcgz_account;
        a[3]=qtxx_account;
        return a;
    };

    @Override
    public Long[] infoPartStatistics(Date startTime, Date endTime){
        Long tzgg_account;
        tzgg_account=adminRepository.getTotalTime("通知公告",startTime,endTime);
        Long jyxx_account;
        jyxx_account=adminRepository.getTotalTime("就业信息",startTime,endTime);
        Long zcgz_account;
        zcgz_account=adminRepository.getTotalTime("政策规章",startTime,endTime);
        Long qtxx_account;
        qtxx_account=adminRepository.getTotalTime("其他信息",startTime,endTime);
        Long[] a = new Long[0];
        a[0]=tzgg_account;
        a[1]=jyxx_account;
        a[2]=zcgz_account;
        a[3]=qtxx_account;
        return a;
    };

    @Override
    public List<Admin> labelStatistics(){
        return adminRepository.findAll();
    };

/*    @Override
    public Long[] userRoleStatistics(){
        Long student_account;
        student_account=adminRepository.getUserRole(1);
        Long teacher_account;
        teacher_account=adminRepository.getUserRole(2);
        Long[] a = new Long[0];
        a[0]=student_account;
        a[1]=teacher_account;
        return a;
    };*/

/*    @Override
    public Long[] userMajorStatistics(){
        Long xg_account;
        xg_account=adminRepository.getUserMajor(major:"信管");
        Long gk_account;
        gk_account=adminRepository.getUserMajor(major:"管科");
        Long rg_account;
        rg_account=adminRepository.getUserMajor(major:"人管");
        Long gg_account;
        gg_account=adminRepository.getUserMajor(major:"公管");
        Long[] a = new Long[0];
        a[0]=xg_account;
        a[1]=gk_account;
        a[2]=rg_account;
        a[3]=gg_account;
        return a;
    };*/

    @Override
    public Long[] adminRoleStatistics(){
        Long superm_account;
        superm_account=adminRepository.getAdminRole("superManager");
        Long m_account;
        m_account=adminRepository.getAdminRole("manager");
        Long[] a = new Long[0];
        a[0]=superm_account;
        a[1]=m_account;
        return a;
    };
}
