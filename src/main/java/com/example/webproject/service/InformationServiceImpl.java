package com.example.webproject.service;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InformationServiceImpl implements InformationService{
    @Autowired
    private InformationRepository informationRepository;

    @Override
    public Information saveInfo(Information information) {
        return informationRepository.save(information);
    }

    @Override
    public Information updateInfo(Information information) {
        return informationRepository.save(information);
    }

    @Override
    public void deleteInfoById(String id) {
        informationRepository.deleteById(id);
    }

    @Override
    public Optional<Information> selectInfoById(String id) {
        return informationRepository.findById(id);
    }

    @Override
    public Page<Information> generalSearch(String keyword) {
        return informationRepository.findByFieldContainingOrSubjectContainingOrAuthorContainingOrLabelsContainingOrContentContainingOrRelationContaining(keyword,keyword,keyword,keyword,keyword,keyword);
    }

    @Override
    public Page<Information> advancedSearch(String formulation) {
        return null;
    }

    @Override
    public Page<Information> show(String field, String subject) {
        return informationRepository.findByFieldAndSubject(field,subject);
    }
}
