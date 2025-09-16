package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Laptop.class);
        configuration.configure();  // this will load the XML

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Laptop l1 = session.find(Laptop.class, 1);
            System.out.println(l1);
            session.close();

            Session session1 = sessionFactory.openSession();
            Laptop l2 = session1.find(Laptop.class, 1);
            System.out.println(l2);
            session1.close();
        } catch (HibernateException err) {
            System.out.println("Error while creating hibernate session : " + err.getMessage());
        }
    }
}