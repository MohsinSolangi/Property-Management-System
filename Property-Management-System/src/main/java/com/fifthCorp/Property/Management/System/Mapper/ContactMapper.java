package com.fifthCorp.Property.Management.System.Mapper;

import com.fifthCorp.Property.Management.System.DTO.ContactDTO;
import com.fifthCorp.Property.Management.System.Model.Contact;

public class ContactMapper {

    public static Contact toEntity(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setContactInfo(dto.getContactInfo());
        contact.setType(dto.getType());
        return contact;
    }

    public static ContactDTO toDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setName(contact.getName());
        dto.setContactInfo(contact.getContactInfo());
        dto.setType(contact.getType());
        return dto;
    }
}
