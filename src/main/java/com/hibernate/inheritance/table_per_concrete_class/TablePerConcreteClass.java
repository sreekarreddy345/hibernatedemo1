package com.hibernate.inheritance.table_per_concrete_class;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TablePerConcreteClass {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Payment payment = new Payment(0, 135);
        CreditCard creditCard = new CreditCard(140, "American Express");
        Cheque cheque = new Cheque(145, "Savings");

        session.save(payment);
        session.save(creditCard);
        session.save(cheque);

        session.getTransaction().commit();
        session.close();
    }
}
