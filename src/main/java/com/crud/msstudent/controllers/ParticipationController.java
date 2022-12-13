package com.crud.msstudent.controllers;

import com.crud.msstudent.exceptions.ParticipationNotFoundException;
import com.crud.msstudent.models.Participation;
import com.crud.msstudent.services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/participation")
public class ParticipationController {
    ParticipationService participationservice;

    @Autowired
    public ParticipationController(ParticipationService participationservice) {
        this.participationservice = participationservice;
    }

    @GetMapping(value = "/")
    public List<Participation> getAllParticipations() {
        return participationservice.getAll();
    }

    @GetMapping(value = "/{id}")
    public Participation getParticipationById(@PathVariable("id") @Min(1) int id) {
        Participation std = participationservice.findById(id)
                .orElseThrow(() -> new ParticipationNotFoundException("Participation with " + id + " is Not Found!"));
        return std;
    }

    @GetMapping(value = "/participant/{id}")
    public List<Participation> findParticipationById_participant(@PathVariable("id") @Min(1) int id) {

        return participationservice.findParticipationById_participant(id);
    }
    @PostMapping(value = "/")
    public Participation addParticipation(@Valid @RequestBody Participation participation) {
        return participationservice.save(participation);
    }

    @PostMapping(value = "/{id}")
    public Participation updateParticipation(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Participation participation) {
        return participationservice.save(participation);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteParticipation(@PathVariable("id") @Min(1) int id) {
        Participation participation = participationservice.findById(id)
                .orElseThrow(() -> new ParticipationNotFoundException("Participation with " + id + " is Not Found!"));
        participationservice.deleteById(participation.getIdParticipation());
        return "Participation with ID :" + id + " is deleted";
    }
}
