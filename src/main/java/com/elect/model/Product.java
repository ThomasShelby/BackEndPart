package com.elect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mykola Yaremchuk on 7/8/17.
 */
@Entity
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFamous() {
        return isFamous;
    }

    public void setFamous(boolean famous) {
        isFamous = famous;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (isFamous != product.isFamous) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (user != null ? !user.equals(product.user) : product.user != null) return false;
        if (imageName != null ? !imageName.equals(product.imageName) : product.imageName != null) return false;
        if (imageUrl != null ? !imageUrl.equals(product.imageUrl) : product.imageUrl != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return registeredOn != null ? registeredOn.equals(product.registeredOn) : product.registeredOn == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (isFamous ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (registeredOn != null ? registeredOn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isFamous=" + isFamous +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", registeredOn='" + registeredOn + '\'' +
                '}';
    }
}
