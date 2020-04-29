package com.hibernate.querylanguage;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaQueryDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Address address = new Address();
        Criteria criteria = session.createCriteria(Address.class);
        criteria.add(Restrictions.le("postalCode", "27107"));
        List<Address> addresses = criteria.list();


        for (Address address : addresses) {
            System.out.println(address);
        }
        System.out.println("addresses size " + addresses.size());

        session.getTransaction().commit();
        session.close();

    }


}
