package com.cesur.splinterio.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.User;
import com.cesur.splinterio.models.dtos.IncidenceDTO;
import com.cesur.splinterio.repositories.IncidenceRepository;
import com.cesur.splinterio.repositories.UserRepository;
import com.cesur.splinterio.services.IncidenceService;

@Service
public class IncidenceServiceImpl implements IncidenceService {

    @Autowired
    IncidenceRepository incidenceRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Incidence> getIncidencesByUserName(String username) {
        User user = userRepository.getUserByEmail(username).get();
        List<Incidence> incidencesByUser = incidenceRepository.findByUser(user.getId()).get();
        return incidencesByUser;
    }

    @Override
    public void storeIncidence(IncidenceDTO datos) {
        Optional<User> user = userRepository.getUserByEmail(datos.getUserCreated());
        if (user.isPresent()) {
            Incidence incidence = new Incidence();
            incidence.setDescription(datos.getDescription());
            incidence.setCreatedAt(LocalDateTime.now());
            incidence.setPriority(datos.getPriority());
            incidence.setScope(datos.getScope());
            incidence.setUserCreated(user.get());
            incidenceRepository.save(incidence);
        }
    }

    @Override
    public void deleteIncidence(Long id) {
        try {
            Incidence incidence = incidenceRepository.findById(id).get();
            incidenceRepository.delete(incidence);
        } catch (Exception e) {
            throw new Error();
        }
    }

    @Override
    public List<Incidence> getAllIncidences() {
        return incidenceRepository.findAll();
    }

    @Override
    public void updatePartialIncidence(Long id, IncidenceDTO datos) {
        Optional<Incidence> incidence = incidenceRepository.findById(id);
        if (!incidence.isEmpty()) {
            Incidence partialIncidence = incidence.get();
            if (datos.getDescription() != null) {
                partialIncidence.setDescription(datos.getDescription());
            }
            if (datos.getPriority() != null) {
                partialIncidence.setPriority(datos.getPriority());
            }
            if (datos.getScope() != null) {
                partialIncidence.setScope(datos.getScope());
            }
            partialIncidence.setUpdateAt(LocalDateTime.now());
            incidenceRepository.save(partialIncidence);
        }
    }

    @Override
    public void updateAllIncidence(Incidence datos) {
        Optional<Incidence> optionalEntity = incidenceRepository.findById(datos.getId());
        if (!optionalEntity.isEmpty()) {
            Incidence fullIncidence = optionalEntity.get();
            fullIncidence.setDescription(datos.getDescription());
            fullIncidence.setPriority(datos.getPriority());
            fullIncidence.setScope(datos.getScope());
            fullIncidence.setUpdateAt(LocalDateTime.now());
            fullIncidence.setUserCreated(datos.getUserCreated());
            incidenceRepository.save(fullIncidence);
        }
    }

}