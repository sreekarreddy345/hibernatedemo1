package com.hibernate.querylanguage;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "address")
@org.hibernate.annotations.NamedQueries({@org.hibernate.annotations.NamedQuery(name = "get_all_addresses",query = "from Address"),
        @org.hibernate.annotations.NamedQuery(name = "get_all_addresses_based_on_district", query = "from Address where district = :district")})
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY,region = "address")

public class Address implements Serializable {
    @Column(name = "address_id")
    @Id
    @GeneratedValue
    private int addressId;
    @Column
    private String address;
    @Column
    private String address2;
    @Column
    private String district;
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "postal_code")
    private String postalCode;
    @Column
    private String phone;
    @Column
    @Lob
    private String location;
    @Column(name = "last_update")
    private Date lastUpdate;

    public Address() {
    }

    public Address(int addressId, String address, String address2, String district, int cityId, String postalCode, String phone, String location, Date lastUpdate) {
        this.addressId = addressId;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.cityId = cityId;
        this.postalCode = postalCode;
        this.phone = phone;
        this.location = location;
        this.lastUpdate = lastUpdate;
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

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", cityId=" + cityId +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
