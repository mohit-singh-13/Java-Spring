package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Rahul");
        s1.setRollNo(46);
        s1.setsAge(21);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.configure();  // this will load the XML

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            session.remove(s1);
            transaction.commit();

            session.close();
        } catch (HibernateException err) {
            System.out.println("Error while creating hibernate session : " + err.getMessage());
        }
    }
}