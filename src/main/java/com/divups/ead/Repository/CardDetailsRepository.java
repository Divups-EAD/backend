package com.divups.ead.Repository;

import com.divups.ead.Entity.CardDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetailsEntity,Integer> {
}
