package com.hibernate.association.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OneToManyDepartment_1")
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "DEPT_NAME")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}