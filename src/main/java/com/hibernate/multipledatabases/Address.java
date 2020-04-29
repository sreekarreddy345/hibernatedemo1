package com.hibernate.multipledatabases;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "multi_DB_addresses")
public class Address implements Serializable {
    @Column(name = "address_id")
    @Id
    @GeneratedValue
    private int addressId;
    @Column
    private String address;
    @Column
    private String district;


    public Address() {
    }

    public Address(int addressId, String address, String district) {
        this.addressId = addressId;
        this.address = address;
        this.district = district;

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
