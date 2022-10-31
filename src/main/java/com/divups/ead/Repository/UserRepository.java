package com.divups.ead.Repository;

import com.divups.ead.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "select * from user WHERE email=:email", nativeQuery = true)
    UserEntity findByEmail(String email);

}
