package com.elect.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Created by Mykola Yaremchuk on 7/11/17.
 */
@Entity
@Table( name = "address" )
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street_name", nullable = false, length = 50)
    @ColumnDefault("'DefaultStreetName'")
    private String streetName;

    @Column(name = "street_number", nullable = false, length = 10)
    @ColumnDefault("'DefaultStreetNumber'")
    private String streetNumber;

    @Column(name = "city", nullable = false, length = 50)
    @ColumnDefault("'DefaultCity'")
    private String city;

    @Column(name = "country", nullable = false, length = 50)
    @ColumnDefault("'DefaultCountry'")
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (streetName != null ? !streetName.equals(address.streetName) : address.streetName != null) return false;
        if (streetNumber != null ? !streetNumber.equals(address.streetNumber) : address.streetNumber != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return country != null ? country.equals(address.country) : address.country == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
