package edu.wctc;

import edu.wctc.entity.crud.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudDemo {
    private SessionFactory factory;

    public CrudDemo() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Donut.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        CrudDemo demo = new CrudDemo();

        try {

            demo.doCrud();

        } finally {
            demo.close();
        }
    }

    private void close() {
        factory.close();
    }

    private void doCrud() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // *** Do CRUD ***

        // Commit the transaction
        session.getTransaction().commit();
    }

}
