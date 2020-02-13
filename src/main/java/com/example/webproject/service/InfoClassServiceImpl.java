package com.example.webproject.service;

import com.example.webproject.entity.InfoClass;
import com.example.webproject.repository.InfoClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class InfoClassServiceImpl implements InfoClassService{

    @Autowired
    private InfoClassRepository infoClassRepository;

    @Transactional
    @Override
    public InfoClass saveOrUpdate(InfoClass infoClass) {
        return infoClassRepository.save(infoClass);
    }

    @Transactional
    @Override
    public void delete(long id) {
        infoClassRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void saveOrUpdateList(List<InfoClass> infoClassList) {
        for(InfoClass infoClass:infoClassList){
            infoClassRepository.save(infoClass);
        }
    }

    @Override
    public List<InfoClass> selectByField(String field) {

        return infoClassRepository.findByField(field);
    }

    @Override
    public InfoClass selectByFieldAndSubValue(String field, String subValue) {
        return infoClassRepository.findByFieldAndSubValue(field, subValue);
    }

    @Override
    public InfoClass selectByFieldAndSubject(String field, String subject) {
        return infoClassRepository.findByFieldAndSubjectLike(field,subject);
    }
}
