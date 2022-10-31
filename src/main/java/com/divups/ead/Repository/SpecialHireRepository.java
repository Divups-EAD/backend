package com.divups.ead.Repository;

import com.divups.ead.Entity.SpecialHireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialHireRepository extends JpaRepository<SpecialHireEntity, Integer> {
//    @Query(value = "select * from users where usr_email =:email", nativeQuery = true)
//    @Query(value = "UPDATE ")
    //User findByEmail(String email);
}
