package edu.agh.bazyprojekt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        System.out.println("sth Happened");
        session.close();
    }
}
