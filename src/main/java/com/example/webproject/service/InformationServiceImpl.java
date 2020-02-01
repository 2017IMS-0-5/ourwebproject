package com.example.webproject.service;

import com.example.webproject.entity.AdSearch;
import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Page<Information> advancedSearch(AdSearch adSearch, Pageable pageable) {
        StringBuilder formulation= new StringBuilder();
        List<String> queryList=new ArrayList<>();

        if(!adSearch.getTitle().equals("")) {
            queryList.add("{\"match\":{\"title\":\"" + adSearch.getTitle() + "\"}}");
        }
        if(!adSearch.getLabel().equals("")) {
            queryList.add("{\"match\":{\"labels\":\"" + adSearch.getLabel() + "\"}}");
        }
        if(!adSearch.getContent().equals("")) {
            queryList.add("{\"match\":{\"content\":\"" + adSearch.getContent() + "\"}}");
        }
        if(!adSearch.getAuthor().equals("")) {
            queryList.add("{\"match\":{\"author\":\"" + adSearch.getAuthor() + "\"}}");
        }
        if(!adSearch.getField().equals("")) {
            queryList.add("{\"match\":{\"field\":\"" + adSearch.getField() + "\"}}");
        }
        if(!adSearch.getSubject().equals("")) {
            queryList.add("{\"match\":{\"subject\":\"" + adSearch.getSubject() + "\"}}");
        }
        if(adSearch.getFrom().equals("")) {
            adSearch.setFrom("2020-01-01");
        }
        if(adSearch.getTo().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            adSearch.setTo(sdf.format(new Date()));
        }
        queryList.add("{\"range\":{\"createTime\": {\"lte\":\""+adSearch.getTo()+"\",\"gte\":\""+adSearch.getFrom()+"\"}}}");

        for(int i=0;i<queryList.size();i++){
            if(i>0){
                formulation.append(",");
            }
            formulation.append(queryList.get(i));
        }
        return informationRepository.findAll(formulation.toString(),pageable);
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
