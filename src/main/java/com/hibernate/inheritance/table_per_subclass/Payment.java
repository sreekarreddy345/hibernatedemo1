package com.hibernate.inheritance.table_per_subclass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payment_SubClass")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "payment_Id")
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


