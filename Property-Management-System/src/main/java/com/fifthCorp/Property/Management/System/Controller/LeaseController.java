package com.fifthCorp.Property.Management.System.Controller;

import com.fifthCorp.Property.Management.System.DTO.LeaseDTO;
import com.fifthCorp.Property.Management.System.Mapper.LeaseMapper;
import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Model.Lease;
import com.fifthCorp.Property.Management.System.Model.Unit;
import com.fifthCorp.Property.Management.System.Repo.ContactRepo;
import com.fifthCorp.Property.Management.System.Repo.UnitRepo;
import com.fifthCorp.Property.Management.System.Service.LeaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/leases")
public class LeaseController {

    private final LeaseService leaseService;
    private final ContactRepo contactRepo;
    private final UnitRepo unitRepo;

    @Autowired
    public LeaseController(LeaseService leaseService, ContactRepo contactRepo, UnitRepo unitRepo) {
        this.leaseService = leaseService;
        this.contactRepo = contactRepo;
        this.unitRepo = unitRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLease(@Valid @RequestBody LeaseDTO leaseDTO) {
        Contact tenant = contactRepo.findById(leaseDTO.getTenantId())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        Contact landlord = contactRepo.findById(leaseDTO.getLandlordId())
                .orElseThrow(() -> new RuntimeException("Landlord not found"));

        Unit unit = unitRepo.findById(leaseDTO.getUnitId())
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        Lease lease = LeaseMapper.toEntity(leaseDTO, tenant, landlord, unit);
        Lease savedLease = leaseService.createLease(lease);
        return ResponseEntity.ok(savedLease);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLeaseById(@PathVariable Long id) {
        Lease lease = leaseService.getLeaseById(id);
        if (lease == null) {
            return ResponseEntity.notFound().build();
        }
        LeaseDTO dto = LeaseMapper.toDTO(lease);
        return ResponseEntity.ok(dto);
    }




}
