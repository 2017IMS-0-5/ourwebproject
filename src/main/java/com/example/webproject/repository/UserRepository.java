package com.example.webproject.repository;

import com.example.webproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户姓名分页查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户年级分页查询用户列表
     * @param grade
     * @param pageable
     * @return
     */
    Page<User> findByGrade(String grade, Pageable pageable);

    /**
     * 根据用户专业分页查询用户列表
     * @param major
     * @param pageable
     * @return
     */
    Page<User> findByMajor(String major, Pageable pageable);

    /**
     * 根据用户角色分页查询用户列表
     * @param role
     * @param pageable
     * @return
     */
    Page<User> findByRole(int role, Pageable pageable);

    /**
     * 根据用户账号分页查询用户列表
     * @param account
     * @param pageable
     * @return
     */
    Page<User> findByAccount(String account, Pageable pageable);

    /**
     * 根据用户角色和姓名分页查询用户列表
     * @param role
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByRoleAndName(int role,String name, Pageable pageable);

    /**
     * 根据用户角色和账号分页查询用户列表
     * @param role
     * @param account
     * @param pageable
     * @return
     */
    Page<User> findByRoleAndAccount(int role,String account, Pageable pageable);

    /**
     * 根据用户角色和年级分页查询用户列表
     * @param role
     * @param grade
     * @param pageable
     * @return
     */
    Page<User> findByRoleAndGrade(int role,String grade, Pageable pageable);

    /**
     * 根据用户角色和专业分页查询用户列表
     * @param role
     * @param major
     * @param pageable
     * @return
     */
    Page<User> findByRoleAndMajor(int role,String major, Pageable pageable);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @Query(name="login",nativeQuery = true,value =
            "select * from user where account=:account and password=:password")
    User login(@Param("account") String account, @Param("password") String password);

    /**
     * 按角色统计用户数量
     * @param role
     * @return
     */
    int countByRole(int role);

    /**
     * 按年级统计学生数量
     * @param role
     * @param grade
     * @return
     */
    int countByRoleAndGrade(int role,String grade);

    /**
     * 统计用户总数
     * @return
     */
    @Query(name="countAllUsers",nativeQuery = true,value =
            "select count(*) from user")
    int countAllUsers();

    /**
     * 根据账号查找用户
     * @param account
     * @return
     */
    User findByAccount(String account);

    List<User> findAll();

}
