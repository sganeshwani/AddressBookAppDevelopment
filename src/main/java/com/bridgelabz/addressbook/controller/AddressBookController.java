package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Create New Entry (Using Service)
    @PostMapping("/add")
    public AddressBook addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.addAddress(addressBookDTO);
    }

    // Get All Entries (Using Service)
    @GetMapping("/all")
    public List<AddressBook> getAllEntries() {
        return addressBookService.getAllEntries();
    }

    // Get Contact By ID
    @GetMapping("/{id}")
    public Optional<AddressBook> getContactById(@PathVariable Long id) {
        return addressBookService.getContactById(id);
    }

    // Update Contact By ID
    @PutMapping("/update/{id}")
    public AddressBook updateContact(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateContact(id, addressBookDTO);
    }

    // Delete Contact By ID
    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        boolean isDeleted = addressBookService.deleteContact(id);
        return isDeleted ? "Contact deleted successfully!" : "Contact not found!";
    }
}