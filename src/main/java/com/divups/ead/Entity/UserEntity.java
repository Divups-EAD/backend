package com.divups.ead.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String username;
    private String firstname;
    private String lastname;
    private String user_role;
    private String email;
    private String password;
    private Date user_createdat;

}
