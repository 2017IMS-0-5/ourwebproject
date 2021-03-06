package com.example.webproject.service;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.User;
import com.example.webproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    @Override
    public Admin SaveNewAdmin(Admin admin) {

        return adminRepository.save(admin);
    }

    @Transactional
    @Override
    public Admin UpdateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Transactional
    @Override
    public void DeleteById(long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Page<Admin> selectAllAdmin(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }

    @Override
    public Page<Admin> selectByAccount(String account, Pageable pageable) {
        return adminRepository.findByAccount(account,pageable);
    }

    @Override
    public Page<Admin> selectByName(String name, Pageable pageable) {
        name="%"+name+"%";
        return adminRepository.findByNameLike(name,pageable);
    }

    @Override
    public Page<Admin> selectByRole(String role, Pageable pageable) {
        return adminRepository.findByRole(role,pageable);
    }

    @Override
    public Admin login(String account, String password) {
        return adminRepository.login(account,password);
    }

    @Override
    public Page<Admin> selectByRoleAndName(String role,String name,Pageable pageable){
        return adminRepository.findByRoleAndNameLike(role,name,pageable);
    }

    @Override
    public Page<Admin> selectByRoleAndAccount(String role,String account,Pageable pageable){
        return adminRepository.findByRoleAndAccount(role, account, pageable);
    }

    @Override
    public int countByRole(String role){
        return adminRepository.countByRole(role);
    }

    @Override
    public Admin selectByAccount(String account){return adminRepository.findByAccount(account);}

    @Override
    public List<Admin> listAdmins(){
        return adminRepository.findAll();
    }
}

