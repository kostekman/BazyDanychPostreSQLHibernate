package edu.agh.bazyprojekt;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;

public class HibernateSessionFactory {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
            Configuration conf = new Configuration();
            conf.configure();

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        sessionFactory = conf.buildSessionFactory(serviceRegistry);

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
