package com.fifthCorp.Property.Management.System.DTO;


import java.time.LocalDate;


public class SummaryDTO {

    // Unit info
    private String unitNumber;
    private String unitType;
    private String unitLocation;
    private int unitValue;
    private String unitStatus;

    // Lease info
    private LocalDate startDate;
    private int duration;
    private int rentAmount;
    private String paymentFrequency;

    // Tenant info
    private String tenantName;
    private String tenantContact;

    // Landlord info
    private String landlordName;
    private String landlordContact;

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitLocation() {
        return unitLocation;
    }

    public void setUnitLocation(String unitLocation) {
        this.unitLocation = unitLocation;
    }

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    public String getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(String unitStatus) {
        this.unitStatus = unitStatus;
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

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantContact() {
        return tenantContact;
    }

    public void setTenantContact(String tenantContact) {
        this.tenantContact = tenantContact;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordContact() {
        return landlordContact;
    }

    public void setLandlordContact(String landlordContact) {
        this.landlordContact = landlordContact;
    }
}

