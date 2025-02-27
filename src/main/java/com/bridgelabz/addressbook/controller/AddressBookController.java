package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    //Create New Entry (Using Service)
    @PostMapping("/add")
    public String addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.addAddress(addressBookDTO);
    }

    //Get All Entries (Using Service)
    @GetMapping("/all")
    public List<AddressBook> getAllEntries() {
        return addressBookService.getAllEntries();
    }
}