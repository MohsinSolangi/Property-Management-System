package com.fifthCorp.Property.Management.System.DTO;

import lombok.Data;
import java.util.List;


public class DashboardDTO {
    private long totalUnits;
    private long vacantUnits;
    private long occupiedUnits;
    private List<LandlordUnitInfo> landlords;
    private long totalRentIncome;
    private List<LeaseSummaryDTO> leases;


    public long getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(long totalUnits) {
        this.totalUnits = totalUnits;
    }

    public long getVacantUnits() {
        return vacantUnits;
    }

    public void setVacantUnits(long vacantUnits) {
        this.vacantUnits = vacantUnits;
    }

    public long getOccupiedUnits() {
        return occupiedUnits;
    }

    public void setOccupiedUnits(long occupiedUnits) {
        this.occupiedUnits = occupiedUnits;
    }

    public List<LandlordUnitInfo> getLandlords() {
        return landlords;
    }

    public void setLandlords(List<LandlordUnitInfo> landlords) {
        this.landlords = landlords;
    }

    public long getTotalRentIncome() {
        return totalRentIncome;
    }

    public void setTotalRentIncome(long totalRentIncome) {
        this.totalRentIncome = totalRentIncome;
    }

    public List<LeaseSummaryDTO> getLeases() {
        return leases;
    }

    public void setLeases(List<LeaseSummaryDTO> leases) {
        this.leases = leases;
    }
}
