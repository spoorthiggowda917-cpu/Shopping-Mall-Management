package com.example.demo.guestbookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.guestbookmanagement.entity.GuestBookEntry;
import com.example.demo.guestbookmanagement.service.GuestBookService;

@RestController
@RequestMapping("/guestbook")
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @PostMapping("/add/{customerId}")
    public GuestBookEntry addEntry(@PathVariable("customerId") Long customerId,
                                   @RequestBody String message) {
        return guestBookService.addEntry(customerId, message);
    }

    @GetMapping("/all")
    public List<GuestBookEntry> getAll() {
        return guestBookService.getAllEntries();
    }

    @GetMapping("/{entryId}")
    public GuestBookEntry getById(@PathVariable("entryId") Long entryId) {
        return guestBookService.getEntryById(entryId);
    }

    @PutMapping("/update/{entryId}")
    public GuestBookEntry update(@PathVariable("entryId") Long entryId,
                                 @RequestBody String message) {
        return guestBookService.updateEntry(entryId, message);
    }

    @DeleteMapping("/delete/{entryId}")
    public String delete(@PathVariable("entryId") Long entryId) {
        return guestBookService.deleteEntry(entryId)
                ? "Entry deleted successfully"
                : "Entry not found";
    }
}