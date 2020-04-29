package com.hibernate.inheritance.table_per_concrete_class;

import javax.persistence.*;

@Entity
@Table(name = "Cheque_ConcreteClass")
@AttributeOverrides({@AttributeOverride(name="amount", column=@Column(name="amount"))//--Read
})
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
