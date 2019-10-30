package edu.wctc;

import edu.wctc.entity.crud.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
            // Create a donut object
            // Donut donut = new Donut(2, "Genaro's Favorite Donut", 450, "genaros-fav", new Date());

            // int newDonutId = demo.createDonut(donut);

            // demo.readDonut(newDonutId);

            // demo.listAllDonuts();

            // demo.updateDonut(1);

            // demo.updateAllDonuts();

            // demo.deleteDonut(1);

            // demo.deleteDonutTen();

        } finally {
            demo.close();
        }
    }

    private void close() {
        factory.close();
    }

    private void tester() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // *** Do CRUD ***
        List<Donut> list = session.createQuery("from Donut").getResultList();
        for (Donut d : list) {
            d.setImageFilename(d.getImageFilename().replaceAll("-", "_"));
        }

        // Commit the transaction
        session.getTransaction().commit();
    }

    private void doCrud() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // *** Do CRUD ***

        // Commit the transaction
        session.getTransaction().commit();
    }

    private int createDonut(Donut donut) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Save the donut object
        session.save(donut);

        System.out.println("Saved donut with generated ID " + donut.getId());

        // Commit the transaction
        session.getTransaction().commit();

        return donut.getId();
    }

    private void readDonut(int donutId) {
        Session session = factory.getCurrentSession();

        // Start a transaction, even for reads
        session.beginTransaction();

        // Retrieve donut based on primary key (ID)
        Donut theDonut = session.get(Donut.class, donutId);

        // Object will be null if no match was found
        if (theDonut == null) {
            System.out.println("Could not find donut with ID " + donutId);
        } else {
            System.out.println(theDonut);
        }

        // Commit the transaction
        session.getTransaction().commit();
    }

    private void listAllDonuts() {
        Session session = factory.getCurrentSession();

        // Start a transaction, even for reads
        session.beginTransaction();

        // Must match name/case of entity object, so "from Donut" will work but "from donut" will not
        List<Donut> allDonuts = session.createQuery("from Donut").getResultList();

        printDonutList(allDonuts);

        // Commit the transaction
        session.getTransaction().commit();
    }

    private void printDonutList(List<Donut> allDonuts) {
        if (allDonuts.isEmpty()) {
            System.out.println("No donuts found");
        } else {
            for (Donut aDonut : allDonuts) {
                System.out.println(aDonut);
            }
        }
    }

    private void updateDonut(int donutId) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Retrieve persistent object from database
        Donut donut = session.get(Donut.class, donutId);

        // May have been null if primary key was not found
        if (donut != null) {
            donut.setName(donut.getName() + " UPDATED");
        }

        // Don't need to explicitly call save/update because the donut
        // is a persistent object. Just commit the session and the
        // update will occur.

        // Commit the transaction
        session.getTransaction().commit();
    }

    private void updateAllDonuts() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Must match name/case of entity object, so "update Donut" will work but "update donut" will not
        session.createQuery("update Donut set calories = calories + 1").executeUpdate();

        // Commit the transaction
        session.getTransaction().commit();
    }

    private void deleteDonut(int donutId) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Retrieve the persistent object
        Donut doomedDonut = session.get(Donut.class, donutId);

        if (doomedDonut != null) {
            // Delete it
            session.delete(doomedDonut);
        }

        // Commit the transaction
        session.getTransaction().commit();
    }

    private void deleteDonutTen() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Use entity object field names, NOT database column names
        // "executeUpdate" is used for deletes because we are still
        // updating the database
        session.createQuery("delete from Donut where id = 10").executeUpdate();

        // Commit the transaction
        session.getTransaction().commit();
    }

}
