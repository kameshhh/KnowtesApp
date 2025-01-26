package com.app.knowtes.services.impl;

import com.app.knowtes.exceptions.ResourceAlreadyPresentException;
import com.app.knowtes.model.User;
import com.app.knowtes.repo.UserRepo;
import com.app.knowtes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        Optional<User> existingUser = this.userRepo.findByUsername(user.getUsername());

        if(existingUser.isPresent()) {
            throw new ResourceAlreadyPresentException("User", "username", user.getUsername());
        }
        return this.userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
