package com.example.webproject.repository;


import com.example.webproject.entity.Admin;
import com.example.webproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    /**
     * 根据管理员账号分页查询管理员+用于登录
     * @param account
     * @param pageable
     * @return
     */
    Page<Admin> findByAccount(String account, Pageable pageable);

    /**
     * 根据管理员姓名分页查询管理员
     * @param name
     * @param pageable
     * @return
     */
    Page<Admin> findByNameLike(String name,Pageable pageable);


    /**
     * 根据管理员角色分页查询管理员
     * @param role
     * @param pageable
     * @return
     */
    Page<Admin> findByRole(String role,Pageable pageable);

    /**
     * 根据管理员角色和姓名查询管理员
     * @param role
     * @param name
     * @param pageable
     * @return
     */
    Page<Admin> findByRoleAndNameLike(String role,String name,Pageable pageable);

    /**
     * 根据管理员角色和账号查询管理员
     * @param role
     * @param account
     * @param pageable
     * @return
     */
    Page<Admin> findByRoleAndAccount(String role,String account,Pageable pageable);

    /**
     * 根据管理员角色统计人数
     * @param role
     * @return
     */
    int countByRole(String role);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @Query(name="login",nativeQuery = true,value =
            "select * from admin where account=:account and password=:password")
    Admin login(@Param("account") String account, @Param("password") String password);

    Admin findByAccount(String account);

    List<Admin> findAll();
}
