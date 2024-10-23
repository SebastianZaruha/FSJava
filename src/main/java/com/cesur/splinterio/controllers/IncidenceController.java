package com.cesur.splinterio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.dtos.IncienceDTO;
import com.cesur.splinterio.services.IncidenceService;

@RestController
@RequestMapping("/incidence")
public class IncidenceController {

    @Autowired
    IncidenceService incidenceService;

    @GetMapping("/list")
    public ResponseEntity<List<Incidence>> getAllIncidences() {
        try {
            return ResponseEntity.ok(incidenceService.getAllIncidences());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Void> storeIncidence(@RequestBody IncienceDTO entity) {
        try {
            incidenceService.storeIncidence(entity);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}