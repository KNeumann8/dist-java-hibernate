package edu.wctc;

import edu.wctc.entity.onetoone.uni.DonutShop;
import edu.wctc.entity.onetoone.uni.DonutShopDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniDemo {
    private SessionFactory factory;

    public OneToOneUniDemo() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(DonutShop.class)
                .addAnnotatedClass(DonutShopDetail.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        OneToOneUniDemo demo = new OneToOneUniDemo();

        try {
            demo.selectShop();

            int newShopId = demo.createShopAndDetail();

            demo.deleteShop(newShopId);
        } finally {
            demo.close();
        }
    }

    private void close() {
        factory.close();
    }

    private void selectShop() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Select a DonutShop by primary key (ID 1)
        DonutShop shop = session.get(DonutShop.class, 1);

        // Print it out to prove that the DonutShopDetail was also fetched
        System.out.println(shop);

        // Commit the transaction
        session.getTransaction().commit();
    }

    private int createShopAndDetail() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();


        session.getTransaction().commit();

        return -1;
    }

    private void deleteShop(int shopId) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();



        session.getTransaction().commit();
    }
}
