package edu.wctc.inclassam.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageFileServiceImpl implements ImageFileService {
    @Override
    public String saveFile(MultipartFile file, String applicationPath, String imageDirectory) {
        String filename = null;
        try {
            if (!file.isEmpty()) {
                String artifactPath = applicationPath
                        + "WEB-INF\\resources\\img\\"
                        + imageDirectory;

                String sourcePath = applicationPath + "..\\..\\..\\"
                        + "web\\WEB-INF\\resources\\img\\"
                        + imageDirectory;

                filename = file.getOriginalFilename();


                File imageFile = new File(artifactPath, filename);
                file.transferTo(imageFile);

                File copyOfImage = new File(sourcePath, filename);
                FileUtils.copyFile(imageFile, copyOfImage);
            }
        } catch (Exception e) {
        }

        return filename;
    }
}
