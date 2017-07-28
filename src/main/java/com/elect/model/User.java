package com.elect.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
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
@Data
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
}