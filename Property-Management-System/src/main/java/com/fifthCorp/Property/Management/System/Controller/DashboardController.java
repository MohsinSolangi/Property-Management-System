package com.fifthCorp.Property.Management.System.Controller;

import com.fifthCorp.Property.Management.System.DTO.LandlordUnitInfo;
import com.fifthCorp.Property.Management.System.DTO.LeaseSummaryDTO;
import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Model.Lease;
import com.fifthCorp.Property.Management.System.Model.Unit;
import com.fifthCorp.Property.Management.System.Repo.ContactRepo;
import com.fifthCorp.Property.Management.System.Repo.LeaseRepo;
import com.fifthCorp.Property.Management.System.Repo.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fifthCorp.Property.Management.System.DTO.DashboardDTO;

import java.util.List;

@RestController
public class DashboardController {

    @Autowired
    private UnitRepo unitRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private LeaseRepo leaseRepo;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardDTO> getDashboard() {
        DashboardDTO dashboard = new DashboardDTO();

        List<Unit> allUnits = unitRepo.findAll();
        List<Contact> allContacts = contactRepo.findAll();
        List<Lease> allLeases = leaseRepo.findAll();

        // Total units & status count
        dashboard.setTotalUnits(allUnits.size());
        dashboard.setVacantUnits(allUnits.stream().filter(u -> u.getStatus().equalsIgnoreCase("Vacant")).count());
        dashboard.setOccupiedUnits(allUnits.stream().filter(u -> u.getStatus().equalsIgnoreCase("Occupied")).count());

        // Landlords with number of units
        List<LandlordUnitInfo> landlordInfos = allContacts.stream()
                .filter(c -> c.getType().name().equals("LANDLORD"))
                .map(landlord -> {
                    LandlordUnitInfo info = new LandlordUnitInfo();
                    info.setLandlordName(landlord.getName());
                    info.setUnitCount(landlord.getOwnedUnits() != null ? landlord.getOwnedUnits().size() : 0);
                    return info;
                }).toList();
        dashboard.setLandlords(landlordInfos);

        // Rent income summary
        long rentIncome = allLeases.stream()
                .mapToLong(Lease::getRentAmount)
                .sum();
        dashboard.setTotalRentIncome(rentIncome);

        // Lease info
        List<LeaseSummaryDTO> leaseSummaries = allLeases.stream()
                .map(lease -> {
                    LeaseSummaryDTO dto = new LeaseSummaryDTO();
                    dto.setUnitNumber(lease.getUnit().getUnitNumber());
                    dto.setTenantName(lease.getTenant().getName());
                    dto.setLandlordName(lease.getLandlord().getName());
                    dto.setRentAmount(lease.getRentAmount());
                    return dto;
                }).toList();
        dashboard.setLeases(leaseSummaries);

        return ResponseEntity.ok(dashboard);
    }
}

