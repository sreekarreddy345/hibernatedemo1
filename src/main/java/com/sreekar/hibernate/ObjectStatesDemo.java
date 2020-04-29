package com.sreekar.hibernate;

import com.sreekar.hibernate.pojo.Student;
import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ObjectStatesDemo {
    public static void main(String[] args) {

        // Transient object state
        Student student = new Student();
        student.setStudentId(101);
        student.setStudentName("reddy");
        student.setMarks(100);

        // Transient object state
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        // Persistent object state
        session.save(student);
        t.commit();
        // Persistent object state
        session.close();
        // Detached object state

    }
}
