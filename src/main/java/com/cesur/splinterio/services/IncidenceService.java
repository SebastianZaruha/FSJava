package com.cesur.splinterio.services;

import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.dtos.IncienceDTO;

import java.util.List;

public interface IncidenceService {
     List<Incidence> getAllIncidences();
    List<Incidence> getIncidencesByUserName(String username);
    void storeIncidence(IncienceDTO datos);
    void deleteIncidence(Long id);
}
