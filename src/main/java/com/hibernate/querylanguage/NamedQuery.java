package com.hibernate.querylanguage;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class NamedQuery {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Address address = new Address();
//        Query<Address> get_addresses = session.createNamedQuery("get_all_addresses", Address.class);
        Query<Address> get_addresses = session.createNamedQuery("get_all_addresses_based_on_district", Address.class);
        get_addresses.setParameter("district","California");

        get_addresses.setFirstResult(0);
        get_addresses.setMaxResults(20);

        List<Address> addresses = get_addresses.list();


        for (Address address : addresses
        ) {
            System.out.println(address);
        }
        System.out.println("addresses size " + addresses.size());

        session.getTransaction().commit();
        session.close();

    }
}
