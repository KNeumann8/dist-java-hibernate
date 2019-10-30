package edu.wctc;

import edu.wctc.entity.onetoone.bi.DonutShop;
import edu.wctc.entity.onetoone.bi.DonutShopDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiDemo {
    private SessionFactory factory;

    public OneToOneBiDemo() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(DonutShop.class)
                .addAnnotatedClass(DonutShopDetail.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        OneToOneBiDemo demo = new OneToOneBiDemo();

        try {
            demo.getShopFromDetail(2999);

            demo.deleteDetail(201);
        } finally {
            demo.close();
        }
    }

    private void close() {
        factory.close();
    }


    private void getShopFromDetail(int detailId) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();


        session.getTransaction().commit();
    }

    private void deleteDetail(int detailId) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();


        session.getTransaction().commit();
    }
}
