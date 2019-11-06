package edu.wctc.inclassam;

import edu.wctc.DateUtils;
import edu.wctc.inclassam.entity.*;
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
                .addAnnotatedClass(DonutShop.class)
                .addAnnotatedClass(DonutShopDetail.class)
                .addAnnotatedClass(DonutReview.class)
                .addAnnotatedClass(City.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        CrudDemo demo = new CrudDemo();

        try {
            demo.createCityAndShop();
        } finally {
            demo.close();
        }
    }

    private void createCityAndShop() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        City city = new City("Pewaukee", "WI");
        session.save(city);

        DonutShop shop = new DonutShop("Stacy's Donuts", "stacys-donut");
        city.add(shop);
        session.save(shop);

        session.getTransaction().commit();
    }

    private void getReviewsForDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Donut aDonut = session.get(Donut.class, 701);
        Donut anotherDonut = session.createQuery("from Donut where name = 'Pineapple'", Donut.class).getSingleResult();

        for (DonutReview review : anotherDonut.getReviews()){
            System.out.println(review);
        }

        session.delete(anotherDonut);

        session.getTransaction().commit();
    }

    private void createReviewsForDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Donut newDonut = new Donut("Pineapple", 300, "pineapple", new Date());
        DonutReview review1 = new DonutReview("Who puts pineapple in a donut??", 1.5, new Date());
        DonutReview review2 = new DonutReview("A revelation!", 4.9, new Date());

        newDonut.add(review1);
        newDonut.add(review2);

        session.save(newDonut);

        session.getTransaction().commit();
    }

    private void deleteDonut2(int donutId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Donut doomedDonut = session.get(Donut.class, donutId);

        if (doomedDonut == null){
            System.out.println("No donut for ID " + donutId);
        } else {
            session.delete(doomedDonut);
        }

        session.getTransaction().commit();
    }

    private void getDonutsForShop(int shopId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        DonutShop aShop = session.get(DonutShop.class, shopId);

        for (Donut aDonut : aShop.getDonuts()) {
            System.out.println(aDonut);
        }

        session.getTransaction().commit();
    }

    private void createDonutsForShop(int shopId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        DonutShop aShop = session.get(DonutShop.class, shopId);

        Donut donut1 = new Donut("Bavarian Créme", 390, "bav-cream", new Date());
        Donut donut2 = new Donut("Cherry", 285, "cherry", new Date());

        aShop.add(donut1);
        aShop.add(donut2);

        session.save(donut1);
        System.out.println(donut1);
        session.save(donut2);
        System.out.println(donut2);

        session.getTransaction().commit();
    }

    private void deleteDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        DonutShopDetail detail = session.get(DonutShopDetail.class, 1);
        detail.getShop().setDetail(null);
       //detail.setShop(null);

        session.delete(detail);

        session.getTransaction().commit();
    }

    private void deleteShopAndDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        DonutShop myShop = session.get(DonutShop.class, 101);

        session.delete(myShop);

        //System.out.println(myShop);

        session.getTransaction().commit();
    }

    private void createShopAndDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        DonutShop shop = new DonutShop("Stacy's Donuts", "stacys-donuts");
        DonutShopDetail detail = new DonutShopDetail(2019, "Waukesha, WI");
        shop.setDetail(detail);

        session.save(shop);

        session.getTransaction().commit();
    }

    private void deleteDonut(int donutId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Donut doomedDonut = session.get(Donut.class, donutId);
        if(doomedDonut != null)
            session.delete(doomedDonut);

        session.getTransaction().commit();
    }

    private void deleteDonutTen() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("delete from Donut where id = 10").executeUpdate();

        session.getTransaction().commit();
    }

    private void updateDate() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Donut aDonut = session.get(Donut.class, 2);
        aDonut.setDateAdded(DateUtils.parseDate("01/01/2019"));

        session.getTransaction().commit();
    }

    private void updateImageFile() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Donut> list = session.createQuery("from Donut").getResultList();
        for (Donut aDonut : list) {
            String newFileName = aDonut.getImageFilename().replaceAll("-", "_");
            aDonut.setImageFilename(newFileName);
        }


        session.getTransaction().commit();
    }

    private void updateDietDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Donut> list = session.createQuery("from Donut order by calories desc").getResultList();
        list.get(0).setName("Definitely not a Diet Donut");

        session.getTransaction().commit();
    }

    private void updateAllDonuts() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("update Donut set calories = calories + 1").executeUpdate();

        session.getTransaction().commit();
    }

    private void updateDonut(int donutId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Donut aDonut = session.get(Donut.class, donutId);
        if (aDonut != null)
            aDonut.setName(aDonut.getName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void listAllDonuts() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Donut> list = session.createQuery("from Donut where calories < 300 order by dateAdded desc").getResultList();

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

        // Do stuff
        Donut aDonut = session.get(Donut.class, donutId);

        if (aDonut == null){
            System.out.println("No donut found for ID " + donutId);
        } else {
            System.out.println(aDonut);
        }

        session.getTransaction().commit();
    }

    private int createDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Date sepFirst = DateUtils.parseDate("09/01/2019");
        Donut donut = new Donut("Marble", 300, "marble.png", sepFirst);

        session.save(donut);

        session.getTransaction().commit();

        return donut.getId();
    }



    private void close() {
        factory.close();
    }
}
