package com.example.webproject.service;

import com.example.webproject.entity.UserFavor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserFavorService {
    /**
     *用户收藏信息
     *@param userFavor
     *@return
     */
    UserFavor saveOrUpdateUserFavor(UserFavor userFavor);

    /**
     根据id获取用户收藏信息
     @param id
     @return
     */
    Optional<UserFavor> getUserFavorById(Long id);

    /**
     根据用户学工号获取用户收藏信息
     @param userAccount
     @return
     */
    Page<UserFavor> getUserFavorByUserAccount(String userAccount, Pageable pageable);

    /**根据学工号和信息ID判断是否有该收藏
     * @param userAccount
     * @param infold
     * @return
     */
    Boolean ifexistsFavor(String userAccount, String infold);
}
