package edu.wctc.inclassam.dao;

import edu.wctc.inclassam.entity.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DonutDAOImpl implements DonutDAO {
    @Autowired
    private SessionFactory sessionFactory;

    // with @Transactional annotation, no need to begin or commit transaction
    @Override
    @Transactional
    public List<Donut> getDonuts() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Create a query
        Query<Donut> query = session.createQuery("from Donut", Donut.class);

        // Get list of NPCs from query
        List<Donut> donutList = query.getResultList();

        // Return results
        return donutList;
    }
}
