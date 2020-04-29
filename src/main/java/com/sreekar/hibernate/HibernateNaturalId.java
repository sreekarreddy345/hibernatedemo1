package com.sreekar.hibernate;

import com.sreekar.hibernate.pojo.natural_id.AccountDetails;
import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class HibernateNaturalId {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            AccountDetails accountDetails = new AccountDetails(1, "Sreekar", "sreekarreddy3456@gmail.com");
            AccountDetails accountDetails1 = new AccountDetails(1, "Sreekar", "sreekarreddy6@gmail.com");
            AccountDetails accountDetails2 = new AccountDetails(1, "Sreekar", "sreekarreddyy6@gmail.com");
            AccountDetails accountDetails3 = new AccountDetails(1, "Sreekar", "sreekarreddy1@gmail.com");
            AccountDetails accountDetails4 = new AccountDetails(1, "Sreekar", "sreekarreddy3@gmail.com");
            Serializable save = session.save(accountDetails);
            System.out.println("save " + save);

//            System.out.println("Value of ID " + id);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            AccountDetails load = session.bySimpleNaturalId(AccountDetails.class).load("sreekarreddy345@gmail.com");

            System.out.println("Value of Load " + load);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }


    }
}
