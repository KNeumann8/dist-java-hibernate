package edu.wctc.inclassam.service;

import edu.wctc.inclassam.dao.DonutShopDAO;
import edu.wctc.inclassam.entity.DonutShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DonutShopServiceImpl implements DonutShopService {
    @Autowired
    private DonutShopDAO donutShopDAO;

    @Override
    @Transactional
    public List<DonutShop> getShops() {
        return donutShopDAO.getShops();
    }

    @Override
    @Transactional
    public DonutShop getShop(int id) {
        return donutShopDAO.getShop(id);
    }
}
