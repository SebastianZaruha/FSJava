package com.cesur.splinterio.services;

import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.dtos.IncidenceDTO;

import java.util.List;

public interface IncidenceService {
     List<Incidence> getAllIncidences();
    List<Incidence> getIncidencesByUserName(String username);
    void storeIncidence(IncidenceDTO datos);
    void updatePartialIncidence(Long id, IncidenceDTO datos);
    void updateAllIncidence(Incidence datos);
    void deleteIncidence(Long id);
}
