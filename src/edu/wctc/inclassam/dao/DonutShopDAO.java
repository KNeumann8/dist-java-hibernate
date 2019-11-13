package edu.wctc.inclassam.dao;

import edu.wctc.inclassam.entity.DonutShop;

import java.util.List;

public interface DonutShopDAO {
    List<DonutShop> getShops();

    DonutShop getShop(int id);
}
