package com.example.webproject.service;

import com.example.webproject.entity.User;
import com.example.webproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // 模糊查询
        name = "%" + name + "%";
        return userRepository.findByNameLike(name, pageable);
    }

    @Override
    public Page<User> listUsersByGrade(String grade, Pageable pageable) {
        return userRepository.findByGrade(grade, pageable);
    }

    @Override
    public Page<User> listUsersByMajor(String major, Pageable pageable) {
        return userRepository.findByMajor(major, pageable);
    }

    @Override
    public Page<User> listUsersByRole(int role, Pageable pageable) {
        return userRepository.findByRole(role, pageable);
    }

    @Override
    public Page<User> listUsersByAccount(String account, Pageable pageable) {
        return userRepository.findByAccount(account, pageable);
    }

    @Override
    public Page<User> listUsersByRoleAndName(int role,String name, Pageable pageable) {
        return userRepository.findByRoleAndName(role,name,pageable);
    }

    @Override
    public Page<User> listUsersByRoleAndAccount(int role,String account, Pageable pageable) {
        return userRepository.findByRoleAndAccount(role,account,pageable);
    }

    @Override
    public Page<User> listUsersByRoleAndGrade(int role,String grade, Pageable pageable) {
        return userRepository.findByRoleAndGrade(role,grade,pageable);
    }

    @Override
    public Page<User> listUsersByRoleAndMajor(int role,String major, Pageable pageable) {
        return userRepository.findByRoleAndMajor(role,major,pageable);
    }

    @Override
    public User login(String account, String password) {
        return userRepository.login(account,password);
    }

    @Override
    public int countUserByRole(int role){
        return userRepository.countByRole(role);
    }

    @Override
    public int countUserByRoleAndGrade(int role,String grade){
        return userRepository.countByRoleAndGrade(role,grade);
    }

    @Override
    public int countAllUsers(){
        return userRepository.countAllUsers();
    }

    @Override
    public List<User> listUsers(){
        return userRepository.findAll();
    }

}