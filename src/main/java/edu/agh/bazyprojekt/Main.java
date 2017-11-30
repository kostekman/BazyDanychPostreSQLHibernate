package edu.agh.bazyprojekt;

import edu.agh.bazyprojekt.model.OrderDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<OrderDetails> query = session.createQuery("from OrderDetails ");

        query.stream().forEach(order -> System.out.println(order.getProduct().getSupplier().getCompanyName()));

        session.close();
    }
}
