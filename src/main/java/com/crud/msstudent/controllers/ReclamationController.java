package com.crud.msstudent.controllers;

import com.crud.msstudent.exceptions.ReclamationNotFoundException;
import com.crud.msstudent.models.Reclamation;
import com.crud.msstudent.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {
    ReclamationService reclamationservice;

    @Autowired
    public ReclamationController(ReclamationService reclamationservice) {
        this.reclamationservice = reclamationservice;
    }

    @GetMapping(value = "/")
    public List<Reclamation> getAllReclamations() {
        return reclamationservice.getAll();
    }


    @GetMapping(value = "/idUser/{id}")
    public List<Reclamation> getAllReclamationsByIdUser(@PathVariable("id") @Min(1) int id) {
        return reclamationservice.findAllByIdUser(id);
    }


    @GetMapping(value = "/{id}")
    public Reclamation getReclamationById(@PathVariable("id") @Min(1) int id) {
        Reclamation std = reclamationservice.findById(id)
                .orElseThrow(() -> new ReclamationNotFoundException("Reclamation with " + id + " is Not Found!"));
        return std;
    }
    @PostMapping(value = "/")
    public Reclamation addReclamation(@Valid @RequestBody Reclamation reclamation) {
        return reclamationservice.save(reclamation);
    }

    @PostMapping(value = "/{id}")
    public Reclamation updateReclamation(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Reclamation reclamation) {
        return reclamationservice.save(reclamation);
    }



    @DeleteMapping(value = "/{id}")
    public String deleteReclamation(@PathVariable("id") @Min(1) int id) {
        Reclamation reclamation = reclamationservice.findById(id)
                .orElseThrow(() -> new ReclamationNotFoundException("Reclamation with " + id + " is Not Found!"));
        reclamationservice.deleteById(reclamation.getId_reclamation());
        return "Reclamation with ID :" + id + " is deleted";
    }
}
