package com.fifthCorp.Property.Management.System.Mapper;

import com.fifthCorp.Property.Management.System.DTO.UnitDTO;
import com.fifthCorp.Property.Management.System.Model.Contact;
import com.fifthCorp.Property.Management.System.Model.Unit;

public class UnitMapper {

    public static Unit toEntity(UnitDTO dto, Contact owner) {
        Unit unit = new Unit();
        unit.setUnitNumber(dto.getUnitNumber());
        unit.setType(dto.getType());
        unit.setLocation(dto.getLocation());
        unit.setValue(dto.getValue());
        unit.setStatus(dto.getStatus());
        unit.setOwner(owner);
        return unit;
    }

    public static UnitDTO toDTO(Unit unit) {
        UnitDTO dto = new UnitDTO();
        dto.setUnitNumber(unit.getUnitNumber());
        dto.setType(unit.getType());
        dto.setLocation(unit.getLocation());
        dto.setValue(unit.getValue());
        dto.setStatus(unit.getStatus());
        dto.setOwnerId(unit.getOwner().getId());
        return dto;
    }
}
