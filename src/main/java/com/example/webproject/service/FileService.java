package com.example.webproject.service;

import com.example.webproject.entity.File;

import java.util.List;

public interface FileService {

    File saveFile(File file);

    void removeFile(String id);

    File getFileById(String id);

    List<File> listFilesByPage(int pageIndex,int pageSize);
}
