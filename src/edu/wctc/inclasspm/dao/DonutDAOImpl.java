package edu.wctc.inclasspm.dao;

import edu.wctc.inclasspm.entity.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonutDAOImpl implements DonutDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Donut> getDonuts() {
        Session session = factory.getCurrentSession();

        List<Donut> list = session.createQuery("from Donut", Donut.class).getResultList();

        return list;
    }

    @Override
    public void saveDonut(Donut aDonut) {
        Session session = factory.getCurrentSession();

        session.save(aDonut);
    }
}
