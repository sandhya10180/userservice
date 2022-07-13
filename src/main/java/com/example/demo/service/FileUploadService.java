package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\bbdnet10180\\curious\\questionUploads" + file.getOriginalFilename()));
        return file.getOriginalFilename();
    }
}
