package edu.agh.bazyprojekt.controller;

import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Map;

public class CriteriaController<K> {

    public Criteria createCriteriaOnMap(Session session, Map<String, Pair<String, Object>> filtersMap, Class clazz){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<K> query = criteriaBuilder.createQuery(clazz);


    return null;



    }
}
