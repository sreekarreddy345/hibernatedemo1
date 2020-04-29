package com.sreekar.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    static SessionFactory sessionFactory;

    static {
        if (sessionFactory == null) {
            System.out.println("getSessionFactory");
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();

        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(String configFilename) {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure(configFilename).build();
        Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        return metaData.getSessionFactoryBuilder().build();
    }
}
