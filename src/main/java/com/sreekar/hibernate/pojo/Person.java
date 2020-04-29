package com.sreekar.hibernate.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Person implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    public Person() {
    }

    public Person(long id) {
        this.id = id;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long PersonId) {
        this.id = PersonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String PersonName) {
        this.name = PersonName;
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
                ", name='" + name + '\'' +
                ", marks=" + age +
                '}';
    }
}

