package com.hibernate.querylanguage;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;

public class NativeQuery {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Address address = new Address();
        String query = "select a.add_count, a.district from \n" +
                "(select   count(district) add_count, district from address group by district) a where a.add_count > 5";
        String query1 = "select * from address";

        org.hibernate.query.NativeQuery nativeQuery = session.createNativeQuery(query);

        List<Object[]> addresses = nativeQuery.list();


        for (Object[] address : addresses
        ) {
            System.out.println(Arrays.toString(address));
        }
        System.out.println("addresses size " + addresses.size());

        session.getTransaction().commit();
        session.close();

    }
}
