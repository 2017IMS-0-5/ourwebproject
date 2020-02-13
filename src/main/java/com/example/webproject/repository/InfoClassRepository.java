package com.example.webproject.repository;

import com.example.webproject.entity.Comment;
import com.example.webproject.entity.InfoClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoClassRepository extends JpaRepository<InfoClass, Long> {

    List<InfoClass> findByField(String field);
    InfoClass findByFieldAndSubValue(String field,String subValue);
    InfoClass findByFieldAndSubjectLike(String field,String subject);
}
