package edu.agh.bazyprojekt.hibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class HibernateSessionFactory {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {

        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
