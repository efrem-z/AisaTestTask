package ru.ez.aisatesttask.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table (name = "usr")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "first name cannot be empty")
    private String firstName;

    @NotBlank(message = "second name cannot be empty")
    private String secondName;


    @Email(message = "email is not correct")
    @NotBlank(message = "email cannot be empty")
    private String email;


    @NotBlank(message = "phone number cannot be empty")
    private String phoneNumber;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
