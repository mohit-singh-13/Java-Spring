package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Lenovo");
        l1.setModel("Ideapad Gaming 3");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("ASUS");
        l2.setModel("ROG");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("DELL");
        l3.setModel("XP");
        l3.setRam(16);

        Student s1 = new Student();
        s1.setsName("Jyoti");
        s1.setRollNo(27);
        s1.setsAge(21);
        s1.setLaptops(Arrays.asList(l1, l2));

        Student s2 = new Student();
        s2.setsName("Mohit");
        s2.setRollNo(36);
        s2.setsAge(22);
        s2.setLaptops(Arrays.asList(l2, l3));

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Laptop.class);
        configuration.configure();  // this will load the XML

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(l1);
            session.persist(l2);
            session.persist(l3);
            session.persist(s1);
            session.persist(s2);
            transaction.commit();

            session.close();
        } catch (HibernateException err) {
            System.out.println("Error while creating hibernate session : " + err.getMessage());
        }
    }
}