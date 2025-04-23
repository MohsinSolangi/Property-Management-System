package com.fifthCorp.Property.Management.System.DTO;


import com.fifthCorp.Property.Management.System.enums.ContactType;
import jakarta.validation.constraints.*;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "ContactService type is required")
    private ContactType type; // LANDLORD or TENANT

    @NotBlank(message = "ContactService info is required")
    private String contactInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}


