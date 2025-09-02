package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setBrand("Lenovo");
        laptop.setModel("Ideapad Gaming 3");
        laptop.setRam(16);

        Student s1 = new Student();
        s1.setsName("Jyoti");
        s1.setRollNo(27);
        s1.setsAge(21);
        s1.setLaptop(laptop);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.configure();  // this will load the XML

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(s1);
            transaction.commit();

            session.close();
        } catch (HibernateException err) {
            System.out.println("Error while creating hibernate session : " + err.getMessage());
        }
    }
}