package com.example.webproject.service;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InformationServiceImpl implements InformationService{
    @Autowired
    private InformationRepository informationRepository;

    @Transactional
    @Override
    public Information saveInfo(Information information) {
        return informationRepository.save(information);
    }

    @Transactional
    @Override
    public Information updateInfo(Information information) {
        return informationRepository.save(information);
    }

    @Transactional
    @Override
    public void deleteInfoById(String id) {
        informationRepository.deleteById(id);
    }

    @Override
    public Optional<Information> selectInfoById(String id) {
        return informationRepository.findById(id);
    }

    @Override
    public Page<Information> generalSearch(String keyword, Pageable pageable) {
        return informationRepository.findByFieldContainingOrSubjectContainingOrAuthorContainingOrLabelsContainingOrContentContainingOrRelationContaining(keyword,keyword,keyword,keyword,keyword,keyword, pageable);
    }

    @Override
    public Page<Information> advancedSearch(String formulation, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Information> show(String field, String subject,Pageable pageable) {
        if(subject.equals("all")){
            return informationRepository.findByField(field,pageable);
        }else return informationRepository.findByFieldAndSubject(field,subject,pageable);
    }

    @Override
    public List<Information> selectByIdList(List<String> infoIdList) {
        List<Information> informationList=new ArrayList<>();
        for(String infoId:infoIdList){
            informationList.add(informationRepository.findById(infoId).get());
        }
        return informationList;
    }

    @Override
    public Page<Information> selectByLabel(String label,Pageable pageable) {
        return informationRepository.findByLabelsContaining(label, pageable);
    }
}
