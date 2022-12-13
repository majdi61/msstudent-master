package com.crud.msstudent.services;

import com.crud.msstudent.models.Camping;

import java.util.List;
import java.util.Optional;

public interface ICamping {
	
    List<Camping> getAllCampings();

    Optional<Camping> findById(int id);

    List<Camping> findAllByEtat(int etat);

    List<Camping> findAllByIdOrganisateur(int id);

    Camping save(Camping camping);

    void deleteById(int id);
    
}
