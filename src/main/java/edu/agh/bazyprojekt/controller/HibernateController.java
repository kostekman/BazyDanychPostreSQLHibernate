package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.hibernateUtils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.BiFunction;

public abstract class HibernateController {
    protected final static SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    protected <T> List<T> findObjects(Class<T> clazz, BiFunction<CriteriaBuilder, Root<T>, Predicate> predicateProvider){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);

        Query<T> query = session.createQuery((javax.persistence.criteria.CriteriaDelete) criteriaQuery.select(root).where(predicateProvider.apply(cb, root)));

        return query.getResultList();
    }


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

    public <T, V> Predicate createEqualPredicate(String key, V value, CriteriaBuilder cb, Root<T> root) {
        return cb.equal(root.get(key), value);
    }

    public <T, V extends Comparable<? super V>> Predicate createLessThanPredicate(String key, V value, CriteriaBuilder cb, Root<T> root) {
        return cb.lessThan(root.get(key), value);
    }

    public <T, V extends Comparable<? super V>> Predicate createGreaterThanPredicate(String key, V value, CriteriaBuilder cb, Root<T> root) {
        return cb.greaterThan(root.get(key), value);
    }

}
