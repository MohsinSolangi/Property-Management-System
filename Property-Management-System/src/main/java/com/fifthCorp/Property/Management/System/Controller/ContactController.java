package com.fifthCorp.Property.Management.System.Controller;

import com.fifthCorp.Property.Management.System.DTO.ContactDTO;
import com.fifthCorp.Property.Management.System.Mapper.ContactMapper;
import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Service.ContactService;
import com.fifthCorp.Property.Management.System.enums.ContactType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {


    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/saveContact")
    public ResponseEntity<ContactDTO> saveContact(@Valid @RequestBody ContactDTO contactDTO) {

         Contact contact = ContactMapper.toEntity(contactDTO);
        contactService.saveContact(contact);
        return ResponseEntity.ok(contactDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        ContactDTO dto = ContactMapper.toDTO(contact);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getAllContacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        try {
            Contact updatedEntity = ContactMapper.toEntity(contactDTO);
            updatedEntity.setId(id); // Set the ID for the updated entity
            Contact updated = contactService.updateContact(id, updatedEntity);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/types")
    public ResponseEntity<List<ContactType>> getContactTypes() {
        return ResponseEntity.ok(Arrays.asList(ContactType.values()));
    }
}
