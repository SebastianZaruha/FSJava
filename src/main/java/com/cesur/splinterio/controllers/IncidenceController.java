package com.cesur.splinterio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesur.splinterio.models.dtos.IncienceDTO;
import com.cesur.splinterio.services.IncidenceService;

@RestController
@RequestMapping("/api")
public class IncidenceController {

    @Autowired
    IncidenceService incidenceService;

    @PostMapping("/incidence")
    public ResponseEntity<Integer> storeIncidence(@RequestBody IncienceDTO entity) {
        try {
            incidenceService.storeIncidence(entity);
            return new ResponseEntity<>(null);
        } catch (Exception e) {
            return new ResponseEntity<>(null);
        }
    }

}
