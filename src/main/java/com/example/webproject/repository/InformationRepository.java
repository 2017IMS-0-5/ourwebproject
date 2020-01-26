package com.example.webproject.repository;

import com.example.webproject.entity.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface InformationRepository extends ElasticsearchRepository<Information,String> {

    /**
     * where id=id;
     * @param id
     * @return
     */
    Optional<Information> findById(String id);

    /**
     * where field=field and subject=subject;
     * @param field
     * @param subject
     * @return
     */
    Page<Information> findByFieldAndSubject(String field,String subject,Pageable pageable);

    /**
     * where field=field;
     * @param field
     * @param pageable
     * @return
     */
    Page<Information> findByField(String field,Pageable pageable);



    Page<Information> findByFieldContainingOrSubjectContainingOrAuthorContainingOrLabelsContainingOrContentContainingOrRelationContaining(String field,String subject,String author,String labels,String content,String relation, Pageable pageable);

    /**
     * 低级全文模糊检索
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    Page<Information> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    /**
     * 文章名字模糊检索
     * @param title
     * @return
     */
    Information findByTitleContaining(String title);

    /**
     * 标签的模糊查询
     * @param label
     * @param pageable
     * @return
     */
    @Query("{ \"match\": {\"labels\": \"?0\"} }")
    Page<Information> findByLabelsContaining(String label,Pageable pageable);
}
