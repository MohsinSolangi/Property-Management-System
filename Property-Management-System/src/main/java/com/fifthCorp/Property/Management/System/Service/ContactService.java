package com.fifthCorp.Property.Management.System.Service;

import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepo contactRepo;

    @Autowired
    ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }
    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public Contact getContactById(Long id) {
        return contactRepo.findById(id).orElse(null);
    }

    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }
    public Contact updateContact(Long id, Contact contact) throws IllegalArgumentException {
        Contact existingContact = contactRepo.findById(id).orElse(null);
        if (existingContact != null) {
            existingContact.setName(contact.getName());
            existingContact.setContactInfo(contact.getContactInfo());
            existingContact.setType(contact.getType());

            return contactRepo.save(existingContact);
        }
         throw new IllegalArgumentException("Contact with ID " + id + " not found.");
    }
}
