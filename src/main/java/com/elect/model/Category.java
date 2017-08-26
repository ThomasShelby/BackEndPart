package com.elect.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykola Yaremchuk on 8/15/17.
 */
@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

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

    @Column(name = "registered_on", length = 20, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String registeredOn;
}

