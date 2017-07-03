package com.elect.model;

/**
 * Created by mykolayaremchuk on 10/4/16.
 */

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
    private Long id;

    @NotNull
    @Size(min=3, max=50)
    @Column(name = "first_name", nullable = false, length = 80)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 80)
    private String last_name;

    @Column(name = "phone", length = 80)
    private String phone;

    @Column(name = "email", unique = true, length = 80)
    private String email;

    @Column(name = "skype", length = 80)
    private String skype;

    @Column(name = "address_id", unique = true, length = 80)
    private String address_id;

    @Column(name = "user_password", nullable = false, unique = true, length = 80)
    private String user_password;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "date_of_birth", length = 20)
    private String date_of_birth;

    @Column(name = "avatar", length = 80)
    private String avatar;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "creation_date", nullable = false, updatable=false)
    private Timestamp creation_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
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

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address) {
        this.address_id = address;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String password) {
        this.user_password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String dateOfBirth) {
        this.date_of_birth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creationDate) {
        this.creation_date = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address='" + address_id + '\'' +
                ", password='" + user_password + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + date_of_birth + '\'' +
                ", avatar='" + avatar + '\'' +
                ", creationDate='" + creation_date + '\'' +
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