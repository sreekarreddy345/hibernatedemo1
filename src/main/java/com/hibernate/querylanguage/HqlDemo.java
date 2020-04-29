package com.hibernate.querylanguage;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HqlDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Address address = new Address();
        Query query = session.createQuery("from Address");
        query.setMaxResults(10);
        List<Address> addresses = query.list();

        Query query1 = session.createQuery("select count(district), district from Address group by district");
        List<Object[]> list = query1.list();// if we don't know the data type which we are retrieving we will keep Object[].

        for (Object count[] : list) {
            System.out.println("Count of district " + Arrays.toString(count));
        }

        for (Address address : addresses
        ) {
            System.out.println(address);
        }
        System.out.println(addresses.size());

        session.getTransaction().commit();
        session.close();

    }
}
