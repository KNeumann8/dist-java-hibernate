package edu.wctc.inclasspm.service.converter;

import edu.wctc.inclasspm.entity.DonutShop;
import edu.wctc.inclasspm.service.DonutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToDonutShopConverter implements Converter<String, DonutShop> {
    @Autowired
    private DonutShopService donutShopService;

    @Override
    public DonutShop convert(String s) {
        int shopId = Integer.parseInt(s);
        DonutShop shop = donutShopService.getDonutShop(shopId);
        return shop;
    }
}
