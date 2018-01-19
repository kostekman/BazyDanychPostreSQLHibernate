package edu.agh.bazyprojekt.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BasicGenericHibernateController<K> {

    private final Session session;

    public BasicGenericHibernateController(Session session){
        this.session = session;
    }

    public void saveObjectsToDb(List<K> objects){
        Transaction transaction = session.beginTransaction();

        for(K object : objects) {
            session.save(object);
        }

        transaction.commit();


    }

    public void removeObjectFromDb(List<K> objects){
        Transaction transaction = session.beginTransaction();
        for(K object : objects) {
            session.delete(object);
        }
        transaction.commit();


    }

    public List<K> selectFromTable(String tableName){
        Query<K> query = session.createQuery("FROM " + tableName);

        return query.getResultList();
    }
}
