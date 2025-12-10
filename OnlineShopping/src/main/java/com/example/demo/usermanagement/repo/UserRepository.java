package com.example.demo.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.usermanagement.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);

}
