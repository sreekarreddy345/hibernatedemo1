package com.hibernate.inheritance.table_per_class_hierarchy;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TablePerClassHierarchy {
    public static void main(String[] args) {
        Session session = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Payment payment = new Payment(0,145);
            CreditCard creditCard = new CreditCard(139, "American Express");
            Cheque cheque = new Cheque(150, "Savings");


            session.save(payment);
            session.save(creditCard);
            session.save(cheque);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();

        } finally {
            session.close();
        }


    }
}
