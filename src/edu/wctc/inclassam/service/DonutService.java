package edu.wctc.inclassam.service;

import edu.wctc.inclassam.entity.Donut;

import java.util.List;

public interface DonutService {
    List<Donut> getDonuts();

    void saveDonut(Donut theDonut);
}
