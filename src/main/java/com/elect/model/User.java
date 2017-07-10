package com.elect.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Entity
@Table( name = "user_card" )
/*Word "user" is registered by system and cannot be used as table name*/
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Column(name = "address_id", length = 30)
    private String addressId;

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

    public void setAddressId(String addressId) {
        this.addressId = addressId;
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
                ", address='" + addressId + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", registeredOn='" + registeredOn + '\'' +
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