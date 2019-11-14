package edu.wctc.inclassam.service;

import edu.wctc.inclassam.dao.DonutDAO;
import edu.wctc.inclassam.entity.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DonutServiceImpl implements DonutService {

    @Autowired
    private ImageFileService imageFileService;

    @Autowired
    private DonutDAO donutDAO;

    @Override
    @Transactional
    public List<Donut> getDonuts() {
        return donutDAO.getDonuts();
    }

    @Override
    @Transactional
    public void saveDonut(Donut aDonut,
                          MultipartFile file,
                          String applicationPath) {
        if (aDonut.getDateAdded() == null) {
            aDonut.setDateAdded(new Date());
        }

        String filename = imageFileService.saveFile(
                file,
                applicationPath,
                aDonut.getShop().getImageDirectory());

        aDonut.setImageFilename(filename);

        donutDAO.saveDonut(aDonut);
    }
}
