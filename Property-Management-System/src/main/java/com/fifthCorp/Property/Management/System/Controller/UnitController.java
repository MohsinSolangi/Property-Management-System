package com.fifthCorp.Property.Management.System.Controller;


import com.fifthCorp.Property.Management.System.DTO.UnitDTO;
import com.fifthCorp.Property.Management.System.Mapper.UnitMapper;
import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Model.Unit;
import com.fifthCorp.Property.Management.System.Repo.ContactRepo;
import com.fifthCorp.Property.Management.System.Service.UnitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;
    private final ContactRepo contactRepo;

    @Autowired
    public UnitController(UnitService unitService, ContactRepo contactRepo) {
        this.unitService = unitService;
        this.contactRepo = contactRepo;
    }

    @PostMapping("/createUnit")
    public ResponseEntity<?> createUnit(@Valid @RequestBody UnitDTO unitDTO) {
        Contact landlord = contactRepo.findById(unitDTO.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Landlord not found"));

        if (landlord.getType().name().equals("TENANT")) {
            return ResponseEntity.badRequest().body("Only a LANDLORD can own a unit.");
        }

        Unit unit = UnitMapper.toEntity(unitDTO, landlord);
        Unit saved = unitService.creatUnit(unit);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUnit(@PathVariable Long id, @RequestBody UnitDTO unitDTO) {
        try {
            Contact contact = contactRepo.findById(unitDTO.getOwnerId())
                    .orElseThrow(() -> new RuntimeException("Landlord not found"));
            Unit updatedEntity = UnitMapper.toEntity(unitDTO,contact);
            updatedEntity.setId(id);
            Unit updated = unitService.updateUnit(id, updatedEntity);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUnitById(@PathVariable Long id) {
        Unit unit = unitService.getUnitById(id);
        if (unit == null) {
            return ResponseEntity.notFound().build();
        }
        UnitDTO dto = UnitMapper.toDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<Unit>> getAllUnits() {
        List<Unit> units = unitService.getAllUnits();
        return ResponseEntity.ok(units);
    }

    }
