package edu.wctc.inclasspm.service;

import edu.wctc.inclasspm.dao.DonutDAO;
import edu.wctc.inclasspm.entity.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DonutServiceImpl implements DonutService {
    @Autowired
    private DonutDAO donutDAO;

    @Autowired
    private ImageFileService imageFileService;

    @Override
    @Transactional
    public List<Donut> getDonuts() {
        return donutDAO.getDonuts();
    }

    @Override
    @Transactional
    public void saveDonut(Donut aDonut, MultipartFile file, String applicationPath) {
        if (aDonut.getDateAdded() == null) {
            aDonut.setDateAdded(new Date());
        }

        String filename = imageFileService.saveFile(
                file, applicationPath, aDonut.getShop().getImageDirectory()
        );

        if (filename != null) {
            aDonut.setImageFilename(filename);
        }

        donutDAO.saveDonut(aDonut);
    }

    @Override
    @Transactional
    public Donut getDonut(int theId) {
        return donutDAO.getDonut(theId);
    }

    @Override
    @Transactional
    public void deleteDonut(int theId) {
        donutDAO.deleteDonut(theId);
    }

    @Override
    @Transactional
    public List<Donut> getDonutsByName(String theSearchTerm) {
        return donutDAO.getDonutsByName(theSearchTerm);
    }
}
