package com.example.webproject.repository;

import com.example.webproject.entity.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InformationRepository extends ElasticsearchRepository<Information,String> {
    Page<Information> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
    Information findByTitleContaining(String title);
}
