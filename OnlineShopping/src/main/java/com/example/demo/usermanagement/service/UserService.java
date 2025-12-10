package com.example.demo.usermanagement.service;

import java.util.List;
import com.example.demo.usermanagement.entity.UserEntity;

public interface UserService {

    UserEntity addNewUser(UserEntity user);

    UserEntity updateUser(UserEntity user);

    UserEntity login(UserEntity user);

    boolean logOut();

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id);

    void deleteUser(Long id);
}
