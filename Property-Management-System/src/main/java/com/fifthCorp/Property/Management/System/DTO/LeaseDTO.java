package com.fifthCorp.Property.Management.System.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
public class LeaseDTO {
    @NotNull(message = "Unit ID is required")
    private Long unitId;

    @NotNull(message = "Tenant ID is required")
    private Long tenantId;

    @NotNull(message = "Landlord ID is required")
    private Long landlordId;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @Min(value = 1, message = "Duration must be at least 1 month")
    private int duration;

    @Positive(message = "Rent amount must be positive")
    private Integer rentAmount;

    @NotBlank(message = "Payment frequency is required")
    private String paymentFrequency; // e.g., Monthly

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Long landlordId) {
        this.landlordId = landlordId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Integer rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }
}