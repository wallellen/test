package com.wallellen.test.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/9/16.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        return conf.buildSessionFactory(build);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
