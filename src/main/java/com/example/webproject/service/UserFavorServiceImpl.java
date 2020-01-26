package com.example.webproject.service;

import com.example.webproject.entity.UserFavor;
import com.example.webproject.repository.UserFavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserFavor> getUserFavorByUserAccount(String userAccount) {
        return userFavorRepository.findByUserAccount(userAccount);
    }
}
