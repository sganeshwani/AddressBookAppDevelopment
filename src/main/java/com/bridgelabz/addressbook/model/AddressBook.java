package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

public class AddressBook {
    private static long idCounter = 1; // Static counter to auto-increment IDs

    private Long id;
    private String name;
    private String address;

    public AddressBook() {}

    // Constructor using DTO
    public AddressBook(AddressBookDTO addressBookDTO) {
        this.id = idCounter++; // Assigning unique ID
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}