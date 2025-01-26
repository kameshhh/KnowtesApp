package com.app.knowtes.services;

import com.app.knowtes.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    User getUserById(Integer userId);
    User getUserByUsername(String username);
    void deleteUser(Integer userId);
    List<User> getAllUsers();

}
