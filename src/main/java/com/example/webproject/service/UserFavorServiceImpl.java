package com.example.webproject.service;

import com.example.webproject.entity.UserFavor;
import com.example.webproject.repository.UserFavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserFavorServiceImpl implements UserFavorService {

    @Autowired
    private UserFavorRepository userFavorRepository;

    @Transactional
    @Override
    public UserFavor saveOrUpdateUserFavor(UserFavor userFavor) {
        return userFavorRepository.save(userFavor);
    }

    @Transactional
    @Override
    public Optional<UserFavor> getUserFavorById(Long id) {
        return userFavorRepository.findById(id);
    }

    @Override
    public Page<UserFavor> getUserFavorByUserAccount(String userAccount, Pageable pageable) {
        return userFavorRepository.findByUserAccount(userAccount, pageable);
    }

    @Override
    public Boolean ifexistsFavor(String userAccount, String infold){
        return userFavorRepository.existsByUserAccountAndInfold(userAccount, infold);
    }

    @Override
    public void deleteUserFavor(String infold,String userAccount){
        userFavorRepository.deleteAllByInfoldAndUserAccount(infold,userAccount);
    }
}
