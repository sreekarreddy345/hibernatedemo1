package com.hibernate.querylanguage;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class SecondLevelCache {
    public static void main(String[] args) {
        loadAddressDetailsGlobal();
    }

    private static void loadAddressDetailsGlobal() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        loadAddressObject(sessionFactory);
        loadAddressObject(sessionFactory);

        sessionFactory.close();
    }

    private static void loadAddressObject(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Address address3 = session.load(Address.class, 1);
        System.out.println("after get address3" + address3);

        Address address4 = session.get(Address.class, 1);
        System.out.println("after get address4" + address4);
        
        session.getTransaction().commit();
        session.close();
    }
}
