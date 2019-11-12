package edu.wctc.inclassam.service;

import edu.wctc.inclassam.entity.DonutShop;

import java.util.List;

public interface DonutShopService {
    List<DonutShop> getDonutShops();

    DonutShop getDonutShop(int id);
}
