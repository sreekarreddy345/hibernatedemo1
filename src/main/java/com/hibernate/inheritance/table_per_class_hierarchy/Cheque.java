package com.hibernate.inheritance.table_per_class_hierarchy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Payment_Details")
@DiscriminatorValue("C")
public class Cheque extends Payment {
    @Column
    private String chequeType;

    public Cheque() {
    }

    public Cheque(double amount, String chequeType) {
        super(amount);
        this.chequeType = chequeType;
    }

    public String getChequeType() {
        return chequeType;
    }

    public void setChequeType(String chequeType) {
        this.chequeType = chequeType;
    }

    @Override
    public String toString() {
        return "Cheque{" +
                "chequeType='" + chequeType + '\'' +
                '}';
    }
}
