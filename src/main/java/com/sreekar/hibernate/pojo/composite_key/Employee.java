package com.sreekar.hibernate.pojo.composite_key;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EmployeeComposite")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Id
    @GeneratedValue
    private long departmentId;

    @Column(name = "First_Name")
    private String firstName;

    @Column
    private int age;


    public Employee() {
    }

    public Employee(long id, long departmentId, String firstName, int age) {
        this.id = id;
        this.departmentId = departmentId;
        this.firstName = firstName;
        this.age = age;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}



