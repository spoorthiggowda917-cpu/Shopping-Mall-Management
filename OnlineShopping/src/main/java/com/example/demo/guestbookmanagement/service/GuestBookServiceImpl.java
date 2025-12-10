package com.example.demo.guestbookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.guestbookmanagement.entity.GuestBookEntry;
import com.example.demo.guestbookmanagement.repo.GuestBookRepository;

@Service
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Override
    public GuestBookEntry addEntry(Long customerId, String message) {
        GuestBookEntry entry = new GuestBookEntry(customerId, message);
        return guestBookRepository.save(entry);
    }

    @Override
    public List<GuestBookEntry> getAllEntries() {
        return guestBookRepository.findAll();
    }

    @Override
    public GuestBookEntry getEntryById(Long entryId) {
        return guestBookRepository.findById(entryId).orElse(null);
    }

    @Override
    public GuestBookEntry updateEntry(Long entryId, String message) {
        GuestBookEntry entry = guestBookRepository.findById(entryId).orElse(null);
        if (entry == null) return null;

        entry.setMessage(message);
        return guestBookRepository.save(entry);
    }

    @Override
    public boolean deleteEntry(Long entryId) {
        if (!guestBookRepository.existsById(entryId))
            return false;

        guestBookRepository.deleteById(entryId);
        return true;
    }
}

