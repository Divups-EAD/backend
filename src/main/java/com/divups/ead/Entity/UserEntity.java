package com.divups.ead.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @NotBlank(message = "Username is required")
    private String username;
    @NotEmpty
    private String firstname;
    private String lastname;
    @NotBlank(message = "user role is required")
    private String user_role;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty @Min(5) @Max(15)
    private String password;
    private Instant user_createdat;

}
