package com.crud.msstudent.controllers;

import com.crud.msstudent.exceptions.CampingNotFoundException;
import com.crud.msstudent.models.Camping;
import com.crud.msstudent.services.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/camping")
public class CampingController {
    CampingService campingservice;

    @Autowired
    public CampingController(CampingService campingservice) {
        this.campingservice = campingservice;
    }

    @GetMapping(value = "/")
    public List<Camping> getAllCampings() {
        return campingservice.getAllCampings();
    }

    @GetMapping(value = "/{id}")
    public Camping getCampingById(@PathVariable("id") @Min(1) int id) {
        Camping std = campingservice.findById(id)
                .orElseThrow(() -> new CampingNotFoundException("Camping with " + id + " is Not Found!"));
        return std;
    }

    @GetMapping(value = "/{etat}")
    public List<Camping> findAllByEtat(@PathVariable("etat") @Min(1) int etat) {
        return  campingservice.findAllByEtat(etat);
    }

    @GetMapping(value = "/org/{id}")
    public List<Camping> findAllByIdOrganisateur(@PathVariable("id") @Min(1) int id) {
        return  campingservice.findAllByIdOrganisateur(id);
    }
    @PostMapping(value = "/")
    public Camping addCamping(@Valid @RequestBody Camping camping) {
        return campingservice.save(camping);
    }

    @PostMapping(value = "/{id}")
    public Camping updateCamping(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Camping camping) {
        return campingservice.save(camping);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCamping(@PathVariable("id") @Min(1) int id) {
        Camping camping = campingservice.findById(id)
                .orElseThrow(() -> new CampingNotFoundException("Camping with " + id + " is Not Found!"));
        campingservice.deleteById(camping.getId_camping());
        return "Camping with ID :" + id + " is deleted";
    }
}
