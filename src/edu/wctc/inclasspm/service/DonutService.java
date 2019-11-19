package edu.wctc.inclasspm.service;

import edu.wctc.inclasspm.entity.Donut;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DonutService {
    List<Donut> getDonuts();

    void saveDonut(Donut aDonut, MultipartFile file, String applicationPath);

    Donut getDonut(int theId);

    void deleteDonut(int theId);

    List<Donut> getDonutsByName(String theSearchTerm);
}
