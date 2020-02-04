package com.example.webproject.repository;

import com.example.webproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
     * 登录
     * @param account
     * @param password
     * @return
     */
    @Query(name="login",nativeQuery = true,value =
            "select * from user where account=:account and password=:password")
    User login(@Param("account") String account, @Param("password") String password);
}
