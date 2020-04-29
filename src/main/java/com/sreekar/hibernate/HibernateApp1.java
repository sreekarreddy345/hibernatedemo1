package com.sreekar.hibernate;

import com.sreekar.hibernate.pojo.Person;
import com.sreekar.hibernate.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApp1 {

    private SessionFactory sessionFactory = null;

    public HibernateApp1() {
        getSessionFactory();
    }
/*
    public Configuration getConfiguration() {
        Configuration config = new Configuration();
        config.addResource("hibernate.cfg.xml");
        return config;e
    }*/

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            System.out.println("getSessionFactory");
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }
    public long saveStudent(Student st) {
        SessionFactory sf = getSessionFactory();
//        Session session = sf.openSession();
        //getCurrentSession
        Session session1 = sf.getCurrentSession();
        Transaction tx = session1.getTransaction();
        tx.begin();
        long id = (long) session1.save(st);
        tx.commit();
        session1.close();
        return id;
    }

    public Student getStudent(long id) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Student stu = session.get(Student.class, id);
        session.close();
        return stu;
    }

    public boolean updateStudent(Student stu) {

        SessionFactory sf = getSessionFactory();
        Session session = null;
        boolean isUpdated = false;
        Transaction tx = null;
        try {
            session = sf.openSession();
            tx = session.getTransaction();
            tx.begin();
            session.update(stu);
            isUpdated = true;
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return isUpdated;
    }

    public boolean deleteStudent(Student stu) {
        SessionFactory sf = getSessionFactory();
        Session session = null;
        boolean isDeleted = false;
        Transaction tx = null;
        try {
            session = sf.openSession();
            tx = session.getTransaction();
            tx.begin();
            session.delete(stu);
            isDeleted = true;
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return isDeleted;
    }

    public long savePerson(Person person) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        long id = (long) session.save(person);

        tx.commit();
        session.close();
        return id;

    }

    public Person getPerson(long personID) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Person per = session.get(Person.class, personID);
        session.close();
        return per;

    }


/*    public boolean deleteMultipleStudent(Student stu) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = null;
        boolean isMultipleStudentDeleted = false;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            session.delete(stu);
            isMultipleStudentDeleted = true;
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isMultipleStudentDeleted;
    }*/
}
