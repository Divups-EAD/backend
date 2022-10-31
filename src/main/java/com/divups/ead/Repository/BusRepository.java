package com.divups.ead.Repository;

import com.divups.ead.Entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<BusEntity,Integer> {
}
