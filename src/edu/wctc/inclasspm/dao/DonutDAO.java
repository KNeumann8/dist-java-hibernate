package edu.wctc.inclasspm.dao;

import edu.wctc.inclasspm.entity.Donut;

import java.util.List;

public interface DonutDAO {

    List<Donut> getDonuts();

    void saveDonut(Donut aDonut);

}
