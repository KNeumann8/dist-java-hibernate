package edu.wctc.inclassam.service;

import edu.wctc.inclassam.entity.Donut;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DonutService {
    List<Donut> getDonuts();

    void saveDonut(Donut aDonut, MultipartFile file, String applicationPath);
}
