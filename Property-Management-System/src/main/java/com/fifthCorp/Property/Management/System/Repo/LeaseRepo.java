package com.fifthCorp.Property.Management.System.Repo;

import com.fifthCorp.Property.Management.System.Model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LeaseRepo extends JpaRepository<Lease, Long> {

}
