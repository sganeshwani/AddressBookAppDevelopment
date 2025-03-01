package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    private final List<AddressBook> addressBookList = new ArrayList<>();

    // Add Contact
    public AddressBook addAddress(AddressBookDTO addressBookDTO) {
        AddressBook newEntry = new AddressBook(addressBookDTO);
        addressBookList.add(newEntry);
        return newEntry; // Returning the added contact
    }

    // Get All Contacts
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    // Get Contact By ID
    public Optional<AddressBook> getContactById(Long id) {
        return addressBookList.stream().filter(contact -> contact.getId().equals(id)).findFirst();
    }

    // Update Contact By ID
    public AddressBook updateContact(Long id, AddressBookDTO addressBookDTO) {
        for (AddressBook contact : addressBookList) {
            if (contact.getId().equals(id)) {
                contact.setName(addressBookDTO.getName());
                contact.setAddress(addressBookDTO.getAddress());
                return contact;
            }
        }
        return null; // If not found, return null
    }

    // Delete Contact By ID
    public boolean deleteContact(Long id) {
        return addressBookList.removeIf(contact -> contact.getId().equals(id));
    }
}