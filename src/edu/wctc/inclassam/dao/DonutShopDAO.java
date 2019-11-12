package edu.wctc.inclassam.dao;

import edu.wctc.inclassam.entity.DonutShop;

import java.util.List;

public interface DonutShopDAO {
    List<DonutShop> getDonutShops();

    DonutShop getDonutShop(int id);
}
