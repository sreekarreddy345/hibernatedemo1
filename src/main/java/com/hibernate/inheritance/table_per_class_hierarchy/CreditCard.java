package com.hibernate.inheritance.table_per_class_hierarchy;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Payment_Details")
@DiscriminatorValue("CC")
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
