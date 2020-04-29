package com.hibernate.association.onetoone;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;


public class OneToOneMappingDemo {

    public static void main(String[] args) {
        long employeeId;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
        Employee employee = new Employee("Nina", "Mayers", new Date(121212), "114-857-965");

        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);


        employeeId = (long) session.save(employee);

        session.flush();

        Employee emp = session.load(employee.getClass(), employeeId);
        System.out.println("emp - " + emp);
        System.out.println("emp.getEmployeeDetail() - " + emp.getEmployeeDetail());


        System.out.println();
        EmployeeDetail empDetails = session.load(employeeDetail.getClass(), employeeId);
        System.out.println("empDetails - " + empDetails);
        System.out.println("empDetails.getEmployee()" + empDetails.getEmployee());

        session.getTransaction().commit();
        session.close();
    }
}
