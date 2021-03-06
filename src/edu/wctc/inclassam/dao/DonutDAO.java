package edu.wctc.inclassam.dao;

import edu.wctc.inclassam.entity.Donut;

import java.util.List;

public interface DonutDAO {
    List<Donut> getDonuts();

    void saveDonut(Donut aDonut);

    Donut getDonut(int theId);

    void deleteDonut(int theId);

    List<Donut> getDonutsByName(String theSearchTerm);
}
