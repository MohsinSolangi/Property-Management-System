package com.fifthCorp.Property.Management.System.DTO;

import jakarta.validation.constraints.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
public class UnitDTO {
    @NotBlank(message = "Unit number is required")
    private String unitNumber;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Location is required")
    private String location;

    @Positive(message = "Value must be positive")
    private int value;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Owner ID is required")
    private Long ownerId;

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}