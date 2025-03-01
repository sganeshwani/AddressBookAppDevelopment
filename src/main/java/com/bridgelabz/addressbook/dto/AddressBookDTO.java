package com.bridgelabz.addressbook.dto;

import lombok.Data;

@Data  // Lombok will auto-generate Getters, Setters, toString, Equals, and HashCode
public class AddressBookDTO {
    private String name;
    private String address;

    public AddressBookDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}