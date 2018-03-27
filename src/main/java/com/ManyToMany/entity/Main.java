package com.ManyToMany.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Session getConnection() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Transaction tx = null;
        Session session = getConnection();

        Users users1 = new Users();
        users1.setName("Maciej");
        users1.setLastName("Swiderski");

        Users users2 = new Users();
        users2.setName("Natalia");
        users2.setLastName("Grzelak");

        Users users3 = new Users();
        users3.setName("Johny");
        users3.setLastName("Bravo");

        Cars cars1 = new Cars();
        cars1.setBrand("Tesla");
        cars1.setYear("2018");

        Cars cars2 = new Cars();
        cars2.setBrand("Jeep");
        cars2.setYear("2018");

        Cars cars3 = new Cars();
        cars3.setBrand("Porshe");
        cars3.setYear("2014");

        Cars cars4 = new Cars();
        cars4.setBrand("Audi Q7");
        cars4.setYear("2014");

        Cars cars5 = new Cars();
        cars5.setBrand("Honda");
        cars5.setYear("2011");

        Cars cars6 = new Cars();
        cars6.setBrand("Toyota");
        cars6.setYear("2014");

        Cars cars7 = new Cars();
        cars7.setBrand("Syrena");
        cars7.setYear("1978");

        Set<Cars> carsSetONE = new HashSet<>();
        carsSetONE.add(cars1);
        carsSetONE.add(cars2);
        carsSetONE.add(cars4);

        Set<Cars> carsSetTWO = new HashSet<>();
        carsSetTWO.add(cars7);
        carsSetTWO.add(cars5);

        Set<Cars> carsSetTHREE = new HashSet<>();
        carsSetTHREE.add(cars1);
        carsSetTHREE.add(cars2);
        carsSetTHREE.add(cars3);
        carsSetTHREE.add(cars4);
        carsSetTHREE.add(cars5);
        carsSetTHREE.add(cars6);
        carsSetTHREE.add(cars7);

        users1.setCarsSet(carsSetONE);
        users2.setCarsSet(carsSetTWO);
        users3.setCarsSet(carsSetTHREE);

        tx = session.beginTransaction();

        session.save(users1);
        session.save(users2);
        session.save(users3);

        tx.commit();

        List<Users> usersList = session.createQuery("From " + Users.class.getName()).list();

        System.out.printf("%-4s | %-15s | %-10s | %-12s", "Id", "Name", "Last name", "Owned cars");
        System.out.println("\n-------------------------------------------------");
        for (Users users : usersList) {
            System.out.printf("%-4s | %-15s | %-10s | %-12s", users.getUserId(), users.getName(), users.getLastName(), users.getCarsSet());
            System.out.println();
        }
    }
}
