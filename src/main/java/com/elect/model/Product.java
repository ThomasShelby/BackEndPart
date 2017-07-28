package com.elect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mykola Yaremchuk on 7/8/17.
 */
@Entity
@Data
@Table( name = "product" )
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=3, max=50)
    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    @Column(name = "image_name", nullable = false, length = 80)
    private String imageName;

    @Column(name = "image_url", length = 80)
    private String imageUrl;

    @Column(name = "isFamous", unique = true, nullable = false, length = 80)
    private boolean isFamous;

    @Column(name = "price", length = 20)
    private double price;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "registered_on", length = 20, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String registeredOn;
}
