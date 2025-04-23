package com.fifthCorp.Property.Management.System.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fifthCorp.Property.Management.System.enums.ContactType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private com.fifthCorp.Property.Management.System.enums.ContactType type;

    private String contactInfo;



    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<Unit> ownedUnits;

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

    public List<Unit> getOwnedUnits() {
        return ownedUnits;
    }

    public void setOwnedUnits(List<Unit> ownedUnits) {
        this.ownedUnits = ownedUnits;
    }
}

