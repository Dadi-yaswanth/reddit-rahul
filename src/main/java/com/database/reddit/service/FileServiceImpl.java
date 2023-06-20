package com.database.reddit.service;

import com.database.reddit.entity.Media;
import com.database.reddit.repository.MediaRepository;
import com.database.reddit.service.interfaces.FileService;
import jakarta.transaction.NotSupportedException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final String mediaPath = "./media";
    private final MediaRepository mediaRepository;

    @Override
    public Media uploadImage(MultipartFile userImageFile) throws IOException, NotSupportedException {
        String originalFilename = userImageFile.getOriginalFilename();
        System.out.println(originalFilename + "--> name");

//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        if (extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".jpeg")) {
//
//        } else if (extension.equalsIgnoreCase(".mp4")) {
//
//        } else {
//            throw new NotSupportedException("file not support");
//        }
        String fileName = UUID.randomUUID().toString().concat(originalFilename.substring(originalFilename.lastIndexOf(".")));

        String filePath = mediaPath + File.separator + fileName;
        System.out.println(filePath + "--> file path");

        File f = new File(mediaPath);

        if (!f.exists()) {
            boolean mkdir = f.mkdir();
            System.out.println(mkdir + "dir created");
        }


        Files.copy(userImageFile.getInputStream(), Paths.get(filePath));

//        Files.copy(userImageFile.getInputStream(), mediaPath.resolve(originalFilename));

        Media media = new Media();
        media.setVideo(false);
        media.setPathUrl(filePath.substring(1));
        return mediaRepository.save(media);
    }

    @Override
    public Resource load(String filename) {
        String filePath = mediaPath+File.separator+filename;
        Path path = Paths.get(filePath);
        try{
            Resource resource = new UrlResource(path.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw  new RuntimeException("could not read the file");
            }
        }catch (MalformedURLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
