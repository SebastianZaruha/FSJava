package com.cesur.splinterio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cesur.splinterio.models.Incidence;

@Repository
public interface IncidenceRepository extends JpaRepository<Incidence, Long> {
    // @Query(value = "SELECT * FROM Incidence WHERE user_id = :userId", nativeQuery = true)        // Native query
    @Query("SELECT i FROM Incidence i WHERE i.userCreated.id = :userId")                            // JPQL query
    Optional<List<Incidence>> findByUser(@Param("userId") Long user);

}
