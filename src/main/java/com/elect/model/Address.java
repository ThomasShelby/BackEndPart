package com.elect.model;

import org.hibernate.annotations.ColumnDefault;
import lombok.Data;

import javax.persistence.*;


/**
 * Created by Mykola Yaremchuk on 7/11/17.
 */
@Entity
@Data
@Table(name = "address")
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
}
