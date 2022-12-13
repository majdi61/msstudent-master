package com.crud.msstudent.services;

import com.crud.msstudent.models.Camping;
import com.crud.msstudent.models.Participation;

import java.util.List;
import java.util.Optional;

public interface IParticipation {

    List<Participation> getAll();

    Optional<Participation> findById(int id);

    List<Participation> findParticipationById_participant (int id);

    Participation save(Participation participation);

    void deleteById(int id);
    
}
