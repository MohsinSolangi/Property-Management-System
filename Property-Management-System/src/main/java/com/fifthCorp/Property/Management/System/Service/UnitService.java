package com.fifthCorp.Property.Management.System.Service;

import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Repo.ContactRepo;
import com.fifthCorp.Property.Management.System.Repo.UnitRepo;
import com.fifthCorp.Property.Management.System.enums.ContactType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fifthCorp.Property.Management.System.Model.Unit;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepo unitRepo;
    private final ContactRepo contactRepo;

    @Autowired
    public UnitService(UnitRepo unitRepo, ContactRepo contactRepo) {
        this.unitRepo = unitRepo;
        this.contactRepo = contactRepo;
    }


    public Unit creatUnit(Unit unit) {
        Contact landlord = contactRepo.findById(unit.getOwner().getId()).
                orElseThrow(() -> new RuntimeException("Landlord not found"));

        if (landlord.getType() != ContactType.LANDLORD) {
            throw new IllegalArgumentException("Owner must be a landlord");

        }
        return unitRepo.save(unit);
    }

    public Unit updateUnit(Long id, Unit unit) {
        Unit existingUnit = unitRepo.findById(id).orElse(null);
        if (existingUnit != null) {
            existingUnit.setUnitNumber(unit.getUnitNumber());
            existingUnit.setType(unit.getType());
            existingUnit.setStatus(unit.getStatus());
            existingUnit.setLocation(unit.getLocation());
            existingUnit.setValue(unit.getValue());
            existingUnit.setOwner(unit.getOwner());
            return unitRepo.save(existingUnit);
        }
        throw new IllegalArgumentException("Unit with ID " + id + " not found.");
    }

    public Unit getUnitById(Long id) {
        return unitRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Unit with ID " + id + " not found."));
    }
    public List<Unit> getAllUnits() {
        return unitRepo.findAll();
    }


}
