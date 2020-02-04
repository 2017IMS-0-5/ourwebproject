package com.example.webproject.service;

import com.example.webproject.entity.InfoClass;

import java.util.List;

public interface InfoClassService {

    /**
     * 新增或更新
     * @param infoClass
     * @return
     */
    InfoClass saveOrUpdate(InfoClass infoClass);

    /**
     * 删除
     * @param id
     */
    void delete(long id);

    /**
     * 批量新增或更新
     * @param infoClassList
     * @return
     */
    void saveOrUpdateList(List<InfoClass> infoClassList);

    List<InfoClass> selectByField(String field);
}
