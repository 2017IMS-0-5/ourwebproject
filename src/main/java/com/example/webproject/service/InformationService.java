package com.example.webproject.service;

import com.example.webproject.entity.AdSearch;
import com.example.webproject.entity.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    Page<Information> generalSearch(String keyword, Pageable pageable);

    /**
     * 高级查询
     * @param adSearch
     * @return
     */
    Page<Information> advancedSearch(AdSearch adSearch, Pageable pageable);

    /**
     * 信息展示
     * @param field
     * @param subject
     * @return
     */
    Page<Information> show(String field, String subject, Pageable pageable);

    /**
     * 根据IdList返回信息List(用户收藏)
     * @param infoIdList
     * @return
     */
    List<Information> selectByIdList(List<String> infoIdList);

    /**
     * 根据标签返回信息（用户推荐）
     * @param label
     * @return
     */
    Page<Information> selectByLabel(String label,Pageable pageable);

    /**
     * 热搜前几
     * @param hotNum
     * @return
     */
    List<Information> findHotInfo(int hotNum);
}
