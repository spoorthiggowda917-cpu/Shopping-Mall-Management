package com.example.demo.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.usermanagement.entity.UserEntity;
import com.example.demo.usermanagement.response.ApiResponse;
import com.example.demo.usermanagement.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Create new user
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserEntity>> register(@RequestBody UserEntity user) {
        UserEntity createdUser = service.addNewUser(user);

        return new ResponseEntity<>(
                new ApiResponse<>(true, "User registered successfully", createdUser),
                HttpStatus.CREATED
        );
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserEntity>> login(@RequestBody UserEntity user) {
        UserEntity loggedInUser = service.login(user);

        if (loggedInUser != null) {
            return new ResponseEntity<>(
                    new ApiResponse<>(true, "Login successful", loggedInUser),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ApiResponse<>(false, "Invalid username or password", null),
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    // Update user
    @PutMapping("/update")
    public ResponseEntity<ApiResponse<UserEntity>> update(@RequestBody UserEntity user) {
        try {
            UserEntity updatedUser = service.updateUser(user);

            return new ResponseEntity<>(
                    new ApiResponse<>(true, "User updated successfully", updatedUser),
                    HttpStatus.OK
            );

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(false, "User not found", null),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    // Get all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserEntity>>> getAllUsers() {
        List<UserEntity> users = service.getAllUsers();
        return new ResponseEntity<>(
                new ApiResponse<>(true, "Users retrieved successfully", users),
                HttpStatus.OK
        );
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserEntity>> getUserById(@PathVariable("id") Long id) {
        try {
            UserEntity user = service.getUserById(id);

            return new ResponseEntity<>(
                    new ApiResponse<>(true, "User found", user),
                    HttpStatus.OK
            );

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(false, "User not found", null),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable("id") Long id) {
        try {
            service.deleteUser(id);

            return new ResponseEntity<>(
                    new ApiResponse<>(true, "User deleted successfully", null),
                    HttpStatus.NO_CONTENT
            );

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(false, "User not found", null),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
