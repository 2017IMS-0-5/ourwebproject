package com.example.webproject.service;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysisServiceImpl implements  AnalysisService{
    @Autowired
    private InformationRepository informationRepository;

    //辅助方法
    protected Integer sumReadSize(List<Information> informationList) {
        Integer totalReadSize=0;
        for (Information information:informationList){
            totalReadSize+=information.getReadSize();
        }
        return totalReadSize;
    }

    @Override
    public List<Integer> getReadSizeByField() {
        List<Information> jobList=informationRepository.findByField("job");
        List<Information> noticeList=informationRepository.findByField("notice");
        List<Information> policyList=informationRepository.findByField("policy");
        List<Information> otherList=informationRepository.findByField("other");
        List<Integer> readSizeList=new ArrayList<>();
        readSizeList.add(sumReadSize(jobList));
        readSizeList.add(sumReadSize(noticeList));
        readSizeList.add(sumReadSize(policyList));
        readSizeList.add(sumReadSize(otherList));
        return readSizeList;
    }

    @Override
    public List<Integer> getInfoSizeByField() {
        List<Integer> sizeList=new ArrayList<>();
        sizeList.add(informationRepository.countByField("job"));
        sizeList.add(informationRepository.countByField("notice"));
        sizeList.add(informationRepository.countByField("policy"));
        sizeList.add(informationRepository.countByField("other"));
        return sizeList;
    }

    @Override
    public Integer countAllInfo() {
        List<Integer> sizeList=getInfoSizeByField();
        Integer sum=0;
        for(Integer integer:sizeList){
            sum+=integer;
        }
        return sum;
    }
}
