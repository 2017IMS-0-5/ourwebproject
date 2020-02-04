package com.example.webproject.service;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.Information;
import com.example.webproject.entity.User;
import com.example.webproject.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface AdminService {

    /**
     * 新增Admin
     * @param admin
     * @return
     */
    Admin SaveNewAdmin(Admin admin);

    /**
     * 更改Admin
     * @param admin
     * @return
     */
    Admin UpdateAdmin(Admin admin);

    /**
     * 根据id删除管理员
     * @param id
     */
    void DeleteById(long id);

    /**
     * 展示所有的Admin
     * @param pageable
     * @return
     */
    Page<Admin> selectAllAdmin(Pageable pageable);

    /**
     * 根据管理员账号查询管理员
     * @param account
     * @param pageable
     * @return
     */
    Page<Admin> selectByAccount(String account,Pageable pageable);

    /**
     * 根据管理员姓名查询管理员
     * @param name
     * @param pageable
     * @return
     */
    Page<Admin> selectByName(String name,Pageable pageable);

    /**
     * 根据管理员角色查询管理员
     * @param role
     * @param pageable
     * @return
     */
    Page<Admin> selectByRole(String role,Pageable pageable);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    Admin login(String account, String password);
}