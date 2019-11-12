package edu.wctc.inclasspm.dao;

import edu.wctc.inclasspm.entity.DonutShop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public class DonutShopDAOImpl implements DonutShopDAO {
    @Autowired
    private SessionFactory factory;


    @Override
    public List<DonutShop> getDonutShops() {
        Session session = factory.getCurrentSession();

        List<DonutShop> list = session.createQuery("from DonutShop", DonutShop.class).getResultList();

        return list;
    }

    @Override
    public DonutShop getDonutShop(int id) {
        Session session = factory.getCurrentSession();

        return session.get(DonutShop.class, id);
    }
}
