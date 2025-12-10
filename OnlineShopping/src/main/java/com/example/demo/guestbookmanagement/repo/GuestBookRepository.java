package com.example.demo.guestbookmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.guestbookmanagement.entity.GuestBookEntry;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBookEntry, Long> {

}

