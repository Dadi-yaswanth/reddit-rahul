package com.database.reddit.service.interfaces;

import com.database.reddit.entity.Media;
import jakarta.transaction.NotSupportedException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface FileService {
    Media uploadImage(MultipartFile multipartFile) throws IOException, NotSupportedException;
    Resource load(String filename);
}