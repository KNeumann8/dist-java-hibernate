package edu.wctc.inclasspm;

import edu.wctc.DateUtils;
import edu.wctc.inclasspm.entity.*;
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

    public void close() {
        factory.close();
    }

    public static void main(String[] args) {
        CrudDemo demo = new CrudDemo();

        try {
            //demo.deleteDonut(301);
            //demo.deleteDonutTen();
            demo.createCityAndShop();

        } finally {
            demo.close();
        }
    }

    private void deleteRaspberryDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Donut doomedDonut = session.get(Donut.class, 1001);
        session.delete(doomedDonut);

        session.getTransaction().commit();
    }

    private void createDonutAndReviews() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Donut aDonut = new Donut("Raspberry Filled", 278, "raspberry", new Date());
        DonutReview review1 = new DonutReview("A revelation!", 10, new Date());
        DonutReview review2 = new DonutReview("Pretty good", 2.5, new Date());

        session.save(aDonut);

        aDonut.add(review1);
        aDonut.add(review2);

        session.getTransaction().commit();
    }

    private void createCityAndShop() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        City city = new City("Tucson", "AZ");
        session.save(city);

        DonutShop shop = new DonutShop("Tyler's Donuts", "tylers-donuts");
        city.add(shop);

        session.getTransaction().commit();
    }

    private void deleteDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        session.createQuery("delete from Donut where name like '%Rainbow%'").executeUpdate();

        session.getTransaction().commit();
    }

    private void printDonutsForShop(int shopId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        DonutShop aShop = session.get(DonutShop.class, shopId);

        for (Donut aDonut : aShop.getDonuts()) {
            System.out.println(aDonut);
        }


        session.getTransaction().commit();
    }

    private void createDonutsForShop(int shopId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        DonutShop aShop = session.get(DonutShop.class, shopId);
        Donut donut1 = new Donut("Rainbow Kringle", 390, "rainbow", new Date() );
        Donut donut2 = new Donut("Deep Fried Long John", 1000, "longjohn", new Date());

        aShop.add(donut1);
        aShop.add(donut2);

        session.getTransaction().commit();
    }

    private void deleteDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        DonutShopDetail aDetail = session.get(DonutShopDetail.class, 201);

        aDetail.getShop().setDetail(null);

        session.delete(aDetail);

        session.getTransaction().commit();
    }

    private void getDetailAndShop() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        DonutShopDetail detail = session.get(DonutShopDetail.class, 201);

        System.out.println(detail);

        session.getTransaction().commit();
    }

    private void createShopAndDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        DonutShop aShop = new DonutShop("Joe's Donuts", "joes");
        DonutShopDetail aDetail = new DonutShopDetail(2019, "Pewaukee, WI");
        aShop.setDetail(aDetail);

        session.save(aShop);

        session.getTransaction().commit();
    }

    private void updateImageFilename() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        List<Donut> list = session.createQuery("from Donut").getResultList();
        for (Donut aDonut : list){
            aDonut.setImageFilename(aDonut.getImageFilename().replaceAll("_", "-"));
        }

        session.getTransaction().commit();
    }

    private void updateDate() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Donut aDonut = session.get(Donut.class, 2);
        Date aNewDate = DateUtils.parseDate("01/31/2019");
        aDonut.setDateAdded(aNewDate);

        session.getTransaction().commit();
    }

    private void updateDietDonut() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        List<Donut> list =
                session.createQuery("from Donut order by calories asc").getResultList();
        list.get(0).setName("Diet Donut");

        session.getTransaction().commit();
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

        Donut donut = new Donut("Chocolate", 275, "marble.png", sepFirst);

        session.save(donut);

        System.out.println(donut);

        session.getTransaction().commit();

        return donut.getId();
    }



}
