package com.fifthCorp.Property.Management.System.Controller;

import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Model.Lease;
import com.fifthCorp.Property.Management.System.Model.Unit;
import com.fifthCorp.Property.Management.System.Repo.LeaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fifthCorp.Property.Management.System.DTO.SummaryDTO;

@RestController
public class SummaryController {

    @Autowired
    private LeaseRepo leaseRepo;

    @GetMapping("/summary/{id}")
    public ResponseEntity<SummaryDTO> getSummary(@PathVariable long id) {
        // Let's assume we always fetch the "test lease" with ID = 1
        Lease lease = leaseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Test Lease not found"));

        Unit unit = lease.getUnit();
        Contact tenant = lease.getTenant();
        Contact landlord = lease.getLandlord();

        SummaryDTO summary = new SummaryDTO();

        // Unit
        summary.setUnitNumber(unit.getUnitNumber());
        summary.setUnitType(unit.getType());
        summary.setUnitLocation(unit.getLocation());
        summary.setUnitValue(unit.getValue());
        summary.setUnitStatus(unit.getStatus());

        // Lease
        summary.setStartDate(lease.getStartDate());
        summary.setDuration(lease.getDuration());
        summary.setRentAmount(lease.getRentAmount());
        summary.setPaymentFrequency(lease.getPaymentFrequency());

        // Tenant
        summary.setTenantName(tenant.getName());
        summary.setTenantContact(tenant.getContactInfo());

        // Landlord
        summary.setLandlordName(landlord.getName());
        summary.setLandlordContact(landlord.getContactInfo());

        return ResponseEntity.ok(summary);
    }
}

