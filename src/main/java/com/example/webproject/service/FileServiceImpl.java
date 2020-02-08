package com.example.webproject.service;

import com.example.webproject.entity.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public File saveFile(File file) {
        return null;
    }

    @Override
    public void removeFile(String id) {

    }

    @Override
    public File getFileById(String id) {
        return null;
    }

    @Override
    public List<File> listFilesByPage(int pageIndex, int pageSize) {
        return null;
    }
}
