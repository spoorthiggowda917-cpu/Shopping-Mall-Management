package com.example.demo.guestbookmanagement.service;

import java.util.List;

import com.example.demo.guestbookmanagement.entity.GuestBookEntry;

public interface GuestBookService {

    GuestBookEntry addEntry(Long customerId, String message);

    List<GuestBookEntry> getAllEntries();

    GuestBookEntry getEntryById(Long entryId);

    GuestBookEntry updateEntry(Long entryId, String message);

    boolean deleteEntry(Long entryId);
}

