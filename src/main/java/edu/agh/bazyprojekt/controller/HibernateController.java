package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.hibernateUtils.HibernateSessionFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class HibernateController<K> {

    protected final Session session;

    public HibernateController(Session session){
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

    public List<K> getFilteredListOfObjects(Map<String, List<Pair<String, Object>>> filtersMap, Class clazz){

        Transaction transaction = session.beginTransaction();

        List<K> listOfObjects = selectFromTable(setupSessionWithFilters(session, filtersMap), clazz.getSimpleName());

        transaction.commit();
        
        return listOfObjects;

    }

    private Session setupSessionWithFilters(Session session, Map<String, List<Pair<String, Object>>> filtersMap){





        return session;
    }

    private List<K> selectFromTable(Session session, String tableName){
        Query<K> query = session.createQuery("FROM " + tableName);

        return query.getResultList();
    }

}
