package com.example.webproject.repository;


import com.example.webproject.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
