package com.sreekar.hibernate;

import com.sreekar.hibernate.pojo.composite_key.Employee;
import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class HibernateCompositeKey {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            Employee employee = new Employee(1, 0002, "Sree", 25);

            Serializable id = session.save(employee);
            System.out.println("Value of ID " + id);
            transaction.commit();
            session.bySimpleNaturalId(Employee.class).load("");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }


    }
}
