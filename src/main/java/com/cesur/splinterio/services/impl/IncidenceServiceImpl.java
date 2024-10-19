package com.cesur.splinterio.services.impl;

import java.util.List;
import java.time.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.dtos.IncienceDTO;
import com.cesur.splinterio.repositories.IncidenceRepository;
import com.cesur.splinterio.services.IncidenceService;

@Service
public class IncidenceServiceImpl implements IncidenceService {

    @Autowired
    IncidenceRepository incidenceRepository;

    @Override
    public List<IncienceDTO> getIncidencesByUserName(String username) {
        throw new UnsupportedOperationException("Unimplemented method 'getIncidencesByUserName'");
    }

    @Override
    public void storeIncidence(IncienceDTO datos) {
        Incidence incidence = new Incidence();
        incidence.setDescription(datos.getDescription());
        incidence.setCreatedAt(LocalDateTime.now());
        incidence.setPriority(datos.getPriority());
        incidence.setScope(datos.getScope());
        incidence.setUserCreated(null);
        incidenceRepository.save(incidence);

    }

    @Override
    public void deleteIncidence(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteIncidence'");
    }

    @Override
    public List getAllIncidences() {
        return incidenceRepository.findAll();
    }

    // @Override
    // public List<Incidence> getAllIncidences() {
    //     return incidenceRepository.findAll();
    // }

}
