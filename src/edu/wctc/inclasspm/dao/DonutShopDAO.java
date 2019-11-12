package edu.wctc.inclasspm.dao;

import edu.wctc.inclasspm.entity.DonutShop;

import java.util.List;

public interface DonutShopDAO {
    List<DonutShop> getDonutShops();

    DonutShop getDonutShop(int id);
}
