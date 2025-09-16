package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Laptop.class);
        configuration.configure();  // this will load the XML

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery("FROM Laptop WHERE ram = 16");
            List<Laptop> laptopList = query.getResultList();

            System.out.println(laptopList);

            session.close();
        } catch (HibernateException err) {
            System.out.println("Error while creating hibernate session : " + err.getMessage());
        }
    }
}