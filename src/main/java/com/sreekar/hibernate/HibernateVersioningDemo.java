package com.sreekar.hibernate;

import com.sreekar.hibernate.pojo.Product;
import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateVersioningDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        Long productId = 0l;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            Product product = new Product(0, "Laptop", 30000);
            productId = (long) session.save(product);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        Product product = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            product = session.get(Product.class, productId);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            product.setPrice(35000);
            session.update(product);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }
}
//Embeddable