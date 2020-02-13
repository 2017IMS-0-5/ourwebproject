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

    /**
     * 查询该类型信息的所有二级标题
     * @param field
     * @return
     */
    List<InfoClass> selectByField(String field);

    InfoClass selectByFieldAndSubValue(String field,String subValue);

    InfoClass selectByFieldAndSubject(String field,String subject);
}
