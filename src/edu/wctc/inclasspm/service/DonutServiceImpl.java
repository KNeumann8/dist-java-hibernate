package edu.wctc.inclasspm.service;

import edu.wctc.inclasspm.dao.DonutDAO;
import edu.wctc.inclasspm.entity.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DonutServiceImpl implements DonutService {
    @Autowired
    private DonutDAO donutDAO;

    @Override
    @Transactional
    public List<Donut> getDonuts() {
        return donutDAO.getDonuts();
    }

    @Override
    @Transactional
    public void saveDonut(Donut aDonut) {
        if (aDonut.getDateAdded() == null) {
            aDonut.setDateAdded(new Date());
        }

        donutDAO.saveDonut(aDonut);
    }
}
