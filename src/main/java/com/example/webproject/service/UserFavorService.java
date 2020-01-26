package com.example.webproject.service;

import com.example.webproject.entity.UserFavor;

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
    List<UserFavor> getUserFavorByUserAccount(String userAccount);
}
