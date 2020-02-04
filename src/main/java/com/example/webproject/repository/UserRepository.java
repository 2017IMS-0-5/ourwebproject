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
     * 根据用户账号查询用户
     * @param account
     * @return
     */
    User findByAccount(String account);

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
