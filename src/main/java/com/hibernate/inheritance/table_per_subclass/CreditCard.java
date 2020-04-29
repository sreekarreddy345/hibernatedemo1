package com.hibernate.inheritance.table_per_subclass;


import javax.persistence.*;

@Entity
@Table(name = "CreditCard_SubClass")
@PrimaryKeyJoinColumn(name = "payment_Id")
public class CreditCard extends Payment {
    @Column
    private String creditCardType;

    public CreditCard() {
    }

    public CreditCard(double amount, String creditCardType) {
        super(amount);
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardType='" + creditCardType + '\'' +
                '}';
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }


}
