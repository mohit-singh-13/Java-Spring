package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Ajay");
        s1.setRollNo(45);
        s1.setsAge(21);

        Student s2;

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.configure();  // this will load the XML

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            s2 = session.find(Student.class, 27);

            session.close();

            System.out.println(s2);
        } catch (HibernateException err) {
            System.out.println("Error while creating hibernate session : " + err.getMessage());
        }
    }
}