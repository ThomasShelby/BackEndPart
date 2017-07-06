package com.elect.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Entity
@Table( name = "user_card" )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min=3, max=50)
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "phone", length = 80)
    private String phone;

    @NotEmpty
    @Column(name = "email", unique = true, nullable = false, length = 80)
    private String email;

    @Column(name = "skype", length = 80)
    private String skype;

    @Column(name = "address_id", length = 80)
    private String addressId;

    @NotNull
    @Column(name = "user_password", nullable = false, length = 80)
    private String userPassword;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "date_of_birth", length = 20)
    private String dateOfBirth;

    @Column(name = "avatar", length = 80)
    private String avatar;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "creation_date", nullable = false, updatable=false)
    private Timestamp creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String address) {
        this.addressId = address;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
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
                ", address='" + addressId + '\'' +
                ", password='" + userPassword + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", avatar='" + avatar + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + id);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
}