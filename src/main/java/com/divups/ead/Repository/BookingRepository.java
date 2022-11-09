package com.divups.ead.Repository;

import com.divups.ead.Entity.BookingEntity;
import com.divups.ead.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
    @Query(value = "select * from booking WHERE customer_id=:id", nativeQuery = true)
    List<BookingEntity> findByUser(Integer id);
}
