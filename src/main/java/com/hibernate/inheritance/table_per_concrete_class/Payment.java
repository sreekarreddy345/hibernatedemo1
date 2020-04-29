package com.hibernate.inheritance.table_per_concrete_class;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payment_ConcreteClass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Payment implements Serializable {
    @Id
    @GeneratedValue
    private int paymentId;
    @Column
    private double amount;

    public Payment() {
    }

    public Payment(double amount) {
        this.amount = amount;
    }

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


