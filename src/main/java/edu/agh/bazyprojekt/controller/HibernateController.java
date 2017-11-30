package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.hibernateUtils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class HibernateController {
    protected final static SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    protected void saveObjectToDb(Object object){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(object);

        transaction.commit();

        session.close();
    }

    protected Object removeObjectFromDb(Object object){
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(object);

        transaction.commit();

        session.close();

        return object;
    }

}
