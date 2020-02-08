package com.example.webproject.repository;

import com.example.webproject.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File,String> {
}
