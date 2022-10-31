package com.divups.ead.Services;

import com.divups.ead.Model.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers() ;

    User getUserById(Integer id);

    User createUser(User user);

    User updateUsers(Integer id, User user);

    boolean userDeleted(Integer id);
}
