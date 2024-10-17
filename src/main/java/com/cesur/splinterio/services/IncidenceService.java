package com.cesur.splinterio.services;
import com.cesur.splinterio.models.dtos.IncienceDTO;

import java.util.List;

public interface IncidenceService {
    IncienceDTO getIncidencesById(Long id);
    List<IncienceDTO> getIncidencesByUserName(String username);
    void storeIncidence(IncienceDTO datos);
    void deleteIncidence(Long id);
}
