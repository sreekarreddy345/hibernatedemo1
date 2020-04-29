package com.hibernate.association.manytomany;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyMappingDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
        Meeting meeting2 = new Meeting("Weekly Status meeting");
        Meeting meeting3 = new Meeting("Weekly Retro meeting");

        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");

        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee1.getMeetings().add(meeting3);
        employee2.getMeetings().add(meeting1);
        employee2.getMeetings().add(meeting3);

        session.save(employee1);
        session.save(employee2);

        session.getTransaction().commit();
        session.close();
    }

}
