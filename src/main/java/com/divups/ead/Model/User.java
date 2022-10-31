package com.divups.ead.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Integer user_id;
    private String username;
    private String firstname;
    private String lastname;
    private String user_role;
    private String email;
    private String password;
    private Instant user_createdat;

}
