package com.fifthCorp.Property.Management.System.Mapper;

import com.fifthCorp.Property.Management.System.DTO.LeaseDTO;
import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Model.Lease;
import com.fifthCorp.Property.Management.System.Model.Unit;

public class LeaseMapper {

    public static Lease toEntity(LeaseDTO dto, Contact tenant, Contact landlord, Unit unit) {
        Lease lease = new Lease();
        lease.setTenant(tenant);
        lease.setLandlord(landlord);
        lease.setUnit(unit);
        lease.setStartDate(dto.getStartDate());
        lease.setDuration(dto.getDuration());
        lease.setRentAmount(dto.getRentAmount());
        lease.setPaymentFrequency(dto.getPaymentFrequency());
        return lease;
    }

    public static LeaseDTO toDTO(Lease lease) {
        LeaseDTO dto = new LeaseDTO();
        dto.setTenantId(lease.getTenant().getId());
        dto.setLandlordId(lease.getLandlord().getId());
        dto.setUnitId(lease.getUnit().getId());
        dto.setStartDate(lease.getStartDate());
        dto.setDuration(lease.getDuration());
        dto.setRentAmount(lease.getRentAmount());
        dto.setPaymentFrequency(lease.getPaymentFrequency());
        return dto;
    }
}
