package com.app.knowtes.controllers;

import com.app.knowtes.model.User;
import com.app.knowtes.payloads.ApiResponse;
import com.app.knowtes.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(
            @Valid
            @RequestBody User user
    ) {
        User createdUser = this.userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(
            @Valid
            @RequestBody User user,
            @PathVariable("userId") Integer uId
    ) {
        User updatedUser = this.userService.updateUser(user, uId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<User> getUserById(
            @PathVariable("userId") Integer uId
    ) {
        User user = this.userService.getUserById(uId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUsers = this.userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByIdOrUsername(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "username", required = false) String username
    ) {
        User user;
        if(userId != null) {
            user = this.userService.getUserById(userId);
        } else if(username != null) {
            user = this.userService.getUserByUsername(username);
        } else {
            throw new IllegalArgumentException("Either userId or username must be provided");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(
            @PathVariable String username
    ) {
        User user = this.userService.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(
            @PathVariable Integer userId
    ) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(
                new ApiResponse("User Deleted Successfully", true),
                HttpStatus.OK);
    }

}
