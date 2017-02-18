package com.mycompany.hibernate.cookbook.entities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author quang
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

//            Configuration configuration = new Configuration();
//            configuration = configuration.configure();
//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
//            builder = builder.applySettings(configuration.getProperties());
//            SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
