package com.example.webproject.service;

import com.example.webproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Optional<User> getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 根据用户年级进行分页查询
     * @param grade
     * @param pageable
     * @return
     */
    Page<User> listUsersByGrade(String grade, Pageable pageable);

    /**
     * 根据用户专业进行分页查询
     * @param major
     * @param pageable
     * @return
     */
    Page<User> listUsersByMajor(String major, Pageable pageable);

    /**
     * 根据用户角色进行分页查询
     * @param role
     * @param pageable
     * @return
     */
    Page<User> listUsersByRole(int role, Pageable pageable);

    /**
     * 根据用户账号进行分页查询
     * @param account
     * @param pageable
     * @return
     */
    Page<User> listUsersByAccount(String account, Pageable pageable);

    /**
     * 根据用户角色和姓名进行分页查询
     * @param role
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByRoleAndName(int role, String name, Pageable pageable);

    /**
     * 根据用户角色和账号进行分页查询
     * @param role
     * @param account
     * @param pageable
     * @return
     */
    Page<User> listUsersByRoleAndAccount(int role, String account, Pageable pageable);

    /**
     * 根据用户角色和年级进行分页查询
     * @param role
     * @param grade
     * @param pageable
     * @return
     */
    Page<User> listUsersByRoleAndGrade(int role, String grade, Pageable pageable);

    /**
     * 根据用户角色和专业进行分页查询
     * @param role
     * @param major
     * @param pageable
     * @return
     */
    Page<User> listUsersByRoleAndMajor(int role, String major, Pageable pageable);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    User login(String account, String password);

    /**
     * 根据角色统计用户
     * @role
     * @return
     */
    int countUserByRole(int role);

    /**
     * 根据年级统计学生数量
     * @role
     * @return
     */
    int countUserByRoleAndGrade(int role,String grade);

    /**
     * 统计用户总数
     * @return
     */
    int countAllUsers();

    User selectByAccount(String account);

    List<User> listUsers();
}
