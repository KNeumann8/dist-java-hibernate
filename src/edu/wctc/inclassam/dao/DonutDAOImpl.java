package edu.wctc.inclassam.dao;

import edu.wctc.inclassam.entity.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonutDAOImpl implements DonutDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Donut> getDonuts() {
        Session session = sessionFactory.getCurrentSession();

        List<Donut> list = session.createQuery("from Donut", Donut.class).getResultList();

        return list;
    }

    @Override
    public void saveDonut(Donut aDonut) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aDonut);
    }

    @Override
    public Donut getDonut(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Donut.class, theId);
    }

    @Override
    public void deleteDonut(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Donut where id = :doomedDonutId");

        query.setParameter("doomedDonutId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Donut> getDonutsByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Donut> query = session.createQuery("from Donut where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}
