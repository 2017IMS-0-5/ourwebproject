package com.example.webproject.service;

import com.example.webproject.entity.Information;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface InformationService {
    /**
     * 上传新文件
     * @param information
     * @return
     */
    Information saveInfo(Information information);

    /**
     * 更新文件
     * @param information
     * @return
     */
    Information updateInfo(Information information);

    /**
     * 根据ID删除文件
     * @param id
     */
    void deleteInfoById(String id);

    /**
     * 根据ID查询文件
     * @param id
     * @return
     */
    Optional<Information> selectInfoById(String id);

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    Page<Information> generalSearch(String keyword);

    /**
     * 高级查询
     * @param formulation
     * @return
     */
    Page<Information> advancedSearch(String formulation);

    /**
     * 信息展示
     * @param field
     * @param subject
     * @return
     */
    Page<Information> show(String field, String subject);
}
