package com.crud.msstudent.services;

import com.crud.msstudent.models.Payment;
import com.crud.msstudent.models.Reclamation;

import java.util.List;
import java.util.Optional;

public interface IReclamation {

    List<Reclamation> getAll();

    Optional<Reclamation> findById(int id);


    List<Reclamation> findAllByIdUser(int idUser);
    Reclamation save(Reclamation reclamation);

    void deleteById(int id);
    
}
