package edu.agh.bazyprojekt;

import edu.agh.bazyprojekt.model.Customer;
import edu.agh.bazyprojekt.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Customer> query = session.createQuery("from Customer ");

        query.stream().forEach(order -> System.out.println(order.getContactName()));

        System.out.println("sth Happened");
        session.close();
    }
}
