package com.crud.msstudent.services;

import com.crud.msstudent.models.Participation;
import com.crud.msstudent.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService implements IParticipation {

    ParticipationRepository participationrepo;

    @Autowired
    public ParticipationService(ParticipationRepository participationrepo) {
        this.participationrepo = participationrepo;
    }

    @Override
    public List<Participation> getAll() {
        // TODO Auto-generated method stub
        return participationrepo.findAll();
    }

    @Override
    public Optional<Participation> findById(int id) {
        // TODO Auto-generated method stub
        return participationrepo.findById(id);
    }

    @Override
    public List<Participation> findParticipationById_participant(int id) {
        // TODO Auto-generated method stub
        return participationrepo.findParticipationByIdParticipant(id);
    }


    @Override
    public Participation save(Participation participation) {
        // TODO Auto-generated method stub
        return participationrepo.save(participation);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        participationrepo.deleteById(id);
    }
}
