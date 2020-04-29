package com.hibernate.multipledatabases;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class MultipleDatabaseDemo {

    public static void main(String[] args) {
        SessionFactory mySqlSessionFactory = null;
        SessionFactory h2SessionFactory = null;
        try {
            mySqlSessionFactory = HibernateUtil.getSessionFactory("mysql_database.cfg.xml");
            h2SessionFactory = HibernateUtil.getSessionFactory("h2_database.cfg.xml");

            Address address = new Address(0, "835 paisley Ct", "IL");
            long addressId1 = saveAddress(mySqlSessionFactory, address);
            long addressId2 = saveAddress(h2SessionFactory, address);

            System.out.println("mySQLDatabseAddress " + addressId1);
            System.out.println("h2DatabseAddress " + addressId2);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            System.out.println("INNNNNNNNNNNN");
            if (mySqlSessionFactory != null){
                System.out.println("mysql");
                mySqlSessionFactory.close();
            }
            if (h2SessionFactory != null){
                System.out.println("h2");
                h2SessionFactory.close();
            }
        }
    }

    public static long saveAddress(SessionFactory sessionFactory, Address address) {
        Session session = null;
        Transaction transaction = null;
        int id = 0;
        try {
            session = sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            id = (int) session.save(address);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) // why transaction will be null...should be id?
                transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();

        }
        return id;
    }


}
