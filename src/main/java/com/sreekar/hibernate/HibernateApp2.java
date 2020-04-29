package com.sreekar.hibernate;

import com.sreekar.hibernate.pojo.Address;
import com.sreekar.hibernate.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApp2 {
    static SessionFactory sessionFactory;

    static {
        if (sessionFactory == null) {
            System.out.println("getSessionFactory");
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        }
    }

    public static void main(String[] args) {
        Address adr = new Address("7-120/3", "Santhi nagar", "Tirupati");
        Employee emp = new Employee(0, "Sreekar", "Vaddi", 20, adr);

        Session session = null;
        Transaction tx = null;

        long id = 0;
        try {
            session = sessionFactory.getCurrentSession();
//            sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            id = (long) session.save(emp);

            System.out.println("Employee ID - " + id);

//            Employee employee = session.get(Employee.class,id);
            Employee employee = session.load(Employee.class, id);
            System.out.println("employee " + employee);
            employee.setFirstName("Jagan");
            employee.setLastName("YS");
            session.update(emp);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
