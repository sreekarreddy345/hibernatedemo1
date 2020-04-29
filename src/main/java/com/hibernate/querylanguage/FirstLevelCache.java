package com.hibernate.querylanguage;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class FirstLevelCache {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Address address3 = session.get(Address.class, 1);
        System.out.println("after get address3");
        Address address4 = session.get(Address.class, 1);
        System.out.println("after get address4");

        Address address1 = session.load(Address.class, 1);
        System.out.println("after load address1");
        Address address2 = session.load(Address.class, 1);
        System.out.println("after load address2");

        System.out.println("address1 - " + address1);
        System.out.println();
        System.out.println("address2 - " + address2);
        System.out.println();



        System.out.println("address3 - " + address3);
        System.out.println();
        System.out.println("address4 - " + address4);


        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        System.out.println();
        Address load = session1.load(Address.class, 1);
        System.out.println();
        System.out.println("load " + load);
        session1.getTransaction().commit();
        session1.close();


    }
}
