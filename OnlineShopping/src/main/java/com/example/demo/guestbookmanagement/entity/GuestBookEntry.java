package com.example.demo.guestbookmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "guest_book")
public class GuestBookEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;

    private Long customerId;
    private String message;

    private LocalDateTime createdAt;

    public GuestBookEntry() {}

    public GuestBookEntry(Long customerId, String message) {
        this.customerId = customerId;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public Long getEntryId() {
        return entryId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

