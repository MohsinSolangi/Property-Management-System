package com.fifthCorp.Property.Management.System.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Unit unit;

    @ManyToOne
    @JsonBackReference
    private Contact tenant;

    @ManyToOne
    @JsonBackReference
    private Contact landlord;

    private LocalDate startDate;
    private int duration;
    private int rentAmount;
    private String paymentFrequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Contact getTenant() {
        return tenant;
    }

    public void setTenant(Contact tenant) {
        this.tenant = tenant;
    }

    public Contact getLandlord() {
        return landlord;
    }

    public void setLandlord(Contact landlord) {
        this.landlord = landlord;
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
}
