package edu.wctc.inclasspm.service;

import edu.wctc.inclasspm.entity.Donut;

import java.util.List;

public interface DonutService {
    List<Donut> getDonuts();

    void saveDonut(Donut aDonut);
}
