package edu.wctc.inclassam.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageFileService {
    String saveFile(MultipartFile file,
                    String applicationPath,
                    String imageDirectory);
}
