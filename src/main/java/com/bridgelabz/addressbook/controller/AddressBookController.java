package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    /*@GetMapping("/test")
    public String testApi() {
        return "Address Book App is Running!";
    }*/
    private List<AddressBook> addressBookList = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity<String> addEntry(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newEntry = new AddressBook(addressBookDTO.name, addressBookDTO.address);
        addressBookList.add(newEntry);
        return new ResponseEntity<>("Entry Added Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return new ResponseEntity<>(addressBookList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable int id) {
        if (id >= 0 && id < addressBookList.size()) {
            return new ResponseEntity<>(addressBookList.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO addressBookDTO) {
        if (id >= 0 && id < addressBookList.size()) {
            AddressBook entry = addressBookList.get(id);
            entry.setName(addressBookDTO.name);
            entry.setAddress(addressBookDTO.address);
            return new ResponseEntity<>("Entry Updated Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        if (id >= 0 && id < addressBookList.size()) {
            addressBookList.remove(id);
            return new ResponseEntity<>("Entry Deleted Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
