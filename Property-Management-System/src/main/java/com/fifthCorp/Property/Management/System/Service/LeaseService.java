package com.fifthCorp.Property.Management.System.Service;

import com.fifthCorp.Property.Management.System.Model.Lease;
import com.fifthCorp.Property.Management.System.Repo.LeaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

    private final LeaseRepo leaseRepo;

    @Autowired
    public LeaseService(LeaseRepo leaseRepo){
        this.leaseRepo = leaseRepo;
    }

    public Lease createLease(Lease lease) {
        return leaseRepo.save(lease);
    }
    public Lease getLeaseById(Long id) {
        return leaseRepo.findById(id).orElse(null);
    }



}
