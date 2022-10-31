package com.divups.ead.Repository;

import com.divups.ead.Entity.BusOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusOwnerRepository extends JpaRepository<BusOwnerEntity, Integer> {
}
