package com.example.ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            if (firstName != null && firstName.length() <= 10) {
                contact.setFirstName(firstName);
            }
            if (lastName != null && lastName.length() <= 10) {
                contact.setLastName(lastName);
            }
            if (phone != null && phone.length() == 10) {
                contact.setPhone(phone);
            }
            if (address != null && address.length() <= 30) {
                contact.setAddress(address);
            }
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
