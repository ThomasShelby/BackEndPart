package com.elect.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Entity
@Table( name = "user_card" )
/*Word "user" is registered by system and cannot be used as table name*/
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="First name should be entered!")
    @Size(min=2, max=50)
    @Column(name = "first_name", nullable = false, length = 80)
    @ColumnDefault("'DefaultFirstName'")
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    @ColumnDefault("'DefaultLastName'")
    private String lastName;

    @Column(name = "phone", length = 80, columnDefinition="varchar(20) default '+77-777-7777-777'")
    private String phone;

    @NotEmpty
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "skype", length = 80, columnDefinition="varchar(30) default 'skype-example'")
    private String skype;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @Column(nullable = true)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    @NotNull(message="Password should be entered!")
    @Column(name = "password", nullable = false, length = 80)
    private String password;

    @Column(name = "gender", length = 10)
    @ColumnDefault("'Male'")
    private String gender;

    @Column(name = "date_of_birth", length = 20, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String dateOfBirth;

    @Column(name = "avatar_url", length = 80, columnDefinition="varchar(100) default 'http://example-avatar-url.elect.com'")
    private String avatarUrl;

    @Column(name = "registered_on", length = 20, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String registeredOn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", registeredOn='" + registeredOn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (skype != null ? !skype.equals(user.skype) : user.skype != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (products != null ? !products.equals(user.products) : user.products != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth != null) return false;
        if (avatarUrl != null ? !avatarUrl.equals(user.avatarUrl) : user.avatarUrl != null) return false;
        return registeredOn != null ? registeredOn.equals(user.registeredOn) : user.registeredOn == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = 31 * result + (registeredOn != null ? registeredOn.hashCode() : 0);
        return result;
    }
}