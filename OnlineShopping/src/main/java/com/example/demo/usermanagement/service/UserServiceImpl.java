package com.example.demo.usermanagement.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.usermanagement.entity.UserEntity;
import com.example.demo.usermanagement.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    // Create new user
    @Override
    public UserEntity addNewUser(UserEntity user) {
        return repo.save(user);
    }

    // Update existing user safely
    @Override
    public UserEntity updateUser(UserEntity user) {
        UserEntity existingUser = repo.findById(user.getId())
                                      .orElseThrow(() -> new NoSuchElementException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setType(user.getType());

        return repo.save(existingUser);
    }

    // Login user
    @Override
    public UserEntity login(UserEntity user) {
        UserEntity existingUser = repo.findByName(user.getName());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        }
        return null;
    }

    // Logout (placeholder)
    @Override
    public boolean logOut() {
        return true;
    }

    // Get all users
    @Override
    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }

    // Get user by ID
    @Override
    public UserEntity getUserById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    // Delete user by ID
    @Override
    public void deleteUser(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("User not found");
        }
        repo.deleteById(id);
    }
}
