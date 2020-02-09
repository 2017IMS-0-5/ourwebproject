package com.example.webproject.service;

import com.example.webproject.entity.Information;

import java.util.List;

public interface AnalysisService {


    /**
     * 获取各类型信息阅读总量
     * @return
     */
    List<Integer> getReadSizeByField();

    /**
     * 获取各类型信息发布数量
     * @return
     */
    List<Integer> getInfoSizeByField();


}
