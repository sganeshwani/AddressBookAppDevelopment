package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {
    private final List<AddressBook> addressBookList = new ArrayList<>();

    // Add Contact
    public String addAddress(AddressBookDTO addressBookDTO) {
        AddressBook newEntry = new AddressBook(addressBookDTO);
        addressBookList.add(newEntry);
        return "Contact Added: " + addressBookDTO.getName();
    }

    // Get All Contacts
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }
}