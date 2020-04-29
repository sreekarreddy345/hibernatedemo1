package com.hibernate.inheritance.table_per_subclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cheque_SubClass")
@PrimaryKeyJoinColumn(name = "payment_Id")
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
