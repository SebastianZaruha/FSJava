package com.cesur.splinterio.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.User;
import com.cesur.splinterio.models.dtos.IncienceDTO;
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
        Optional<List<Incidence>> incidencesByUser = incidenceRepository.findByUser(user);
        return incidencesByUser.get();
    }

    @Override
    public void storeIncidence(IncienceDTO datos) {
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
        // Incidence incidence = incidenceRepository.findById(id).get();
        incidenceRepository.deleteById(id);
    }

    @Override
    public List<Incidence> getAllIncidences() {
        return incidenceRepository.findAll();
    }

}