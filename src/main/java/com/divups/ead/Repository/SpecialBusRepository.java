package com.divups.ead.Repository;

import com.divups.ead.Entity.SpecialBusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialBusRepository extends JpaRepository<SpecialBusEntity, Integer> {
}
