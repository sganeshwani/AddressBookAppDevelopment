package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private List<AddressBook> addressBookList = new ArrayList<>();

    // Create New Entry (Using DTO)
    @PostMapping("/add")
    public String addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newEntry = new AddressBook(addressBookDTO);
        addressBookList.add(newEntry);
        return "Contact Added: " + addressBookDTO.getName();
    }

    // Get All Entries
    @GetMapping("/all")
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }
}