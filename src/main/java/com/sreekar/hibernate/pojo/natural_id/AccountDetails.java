package com.sreekar.hibernate.pojo.natural_id;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AccountDetails")
public class AccountDetails implements Serializable {


    @Id
    @GeneratedValue
    private long id;


    @Column(name = "First_Name")
    private String firstName;

    @Column
    @NaturalId
    private String emailId;

    public AccountDetails(long id, String firstName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.emailId = emailId;
    }

    public AccountDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
