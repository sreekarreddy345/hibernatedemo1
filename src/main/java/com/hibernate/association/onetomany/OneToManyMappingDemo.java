package com.hibernate.association.onetomany;

import com.sreekar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Set;

public class OneToManyMappingDemo {

    public static void main(String[] args) {
        long employeeId;
        long departmentId;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee emp1 = new Employee("Sreekar", "vaddi", "111");
        Employee emp2 = new Employee("reddy", "vaddi", "222");


        Department department = new Department();
        department.setDepartmentName("IT_Department");

        departmentId = (long) session.save(department);
        department.setDepartmentId(departmentId);
        emp1.setDepartment(department);
        emp2.setDepartment(department);

        session.save(emp1);
        session.save(emp2);
        Set<Employee> employees = new HashSet<>(2);
        employees.add(emp1);
        employees.add(emp2);
        department.setEmployees(employees);
        session.save(department);
        session.flush();

        Department loadDetails = session.load(department.getClass(), departmentId);

        System.out.println("loadDetails " + loadDetails);
        System.out.println("loadDetails getdepartment " + loadDetails.getEmployees());

        session.getTransaction().commit();
        session.close();

    }
}
