package edu.wctc.inclasspm;

import edu.wctc.DateUtils;
import edu.wctc.inclasspm.entity.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class CrudDemo {
    private SessionFactory factory;

    public CrudDemo() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Donut.class)
                .buildSessionFactory();
    }

    public void close() {
        factory.close();
    }

    public static void main(String[] args) {
        CrudDemo demo = new CrudDemo();

        try {
            demo.deleteDonut(301);
            demo.deleteDonutTen();
        } finally {
            demo.close();
        }
    }

    private void deleteDonutTen() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        session.createQuery("delete from Donut where id = 10").executeUpdate();

        session.getTransaction().commit();
    }

    private void deleteDonut(int donutId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Donut aDonut = session.get(Donut.class, donutId);
        if (aDonut != null)
            session.delete(aDonut);


        session.getTransaction().commit();
    }

    private void updateAllDonuts() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        session.createQuery("update Donut set calories = calories + 10").executeUpdate();


        session.getTransaction().commit();
    }

    private void updateDonut(int donutId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Donut aDonut = session.get(Donut.class, donutId);
        if (aDonut != null)
            aDonut.setName(aDonut.getName().toUpperCase());
        System.out.println(aDonut);

        session.getTransaction().commit();
    }

    private void listAllDonuts() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        List<Donut> list = session.createQuery("from Donut").getResultList();
        printDonutList(list);

        session.getTransaction().commit();
    }

    private void printDonutList(List<Donut> list) {
        if (list.isEmpty()) {
            System.out.println("No donuts in list");
        } else {
            for (Donut donut : list) {
                System.out.println(donut);
            }
        }
    }

    private void readDonut(int donutId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Donut aDonut = session.get(Donut.class, donutId);

        System.out.println(aDonut);

        session.getTransaction().commit();
    }

    private int createDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Date sepFirst = DateUtils.parseDate("09/01/2019");

        Donut donut = new Donut(1, "Chocolate", 275, "marble.png", sepFirst);

        session.save(donut);

        System.out.println(donut);

        session.getTransaction().commit();

        return donut.getId();
    }

    private void crudTemplate() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        session.getTransaction().commit();
    }

}
