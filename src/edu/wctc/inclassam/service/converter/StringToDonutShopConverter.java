package edu.wctc.inclassam.service.converter;

import edu.wctc.inclassam.entity.DonutShop;
import edu.wctc.inclassam.service.DonutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToDonutShopConverter implements Converter<String, DonutShop> {

    @Autowired
    private DonutShopService donutShopService;

    @Override
    public DonutShop convert(String s) {
        int shopId = Integer.parseInt(s);

        DonutShop aShop = donutShopService.getShop(shopId);

        return aShop;
    }
}
