package edu.wctc.inclasspm.service;

import edu.wctc.inclasspm.entity.DonutShop;

import java.util.List;

public interface DonutShopService {

    List<DonutShop> getDonutShops();

    DonutShop getDonutShop(int id);

}
