package com.cesur.splinterio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesur.splinterio.models.Incidence;

@Repository
public interface IncidenceRepository extends JpaRepository<Incidence, Long>{

}
