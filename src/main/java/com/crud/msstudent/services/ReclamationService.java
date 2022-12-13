package com.crud.msstudent.services;

import com.crud.msstudent.models.Reclamation;
import com.crud.msstudent.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService implements IReclamation {

    ReclamationRepository reclamationrepo;

    @Autowired
    public ReclamationService(ReclamationRepository reclamationrepo) {
        this.reclamationrepo = reclamationrepo;
    }

    @Override
    public List<Reclamation> getAll() {
        // TODO Auto-generated method stub
        return reclamationrepo.findAll();
    }

    @Override
    public Optional<Reclamation> findById(int id) {
        // TODO Auto-generated method stub
        return reclamationrepo.findById(id);
    }

    @Override
    public List<Reclamation>  findAllByIdUser(int idUser) {
        // TODO Auto-generated method stub
        return reclamationrepo.findAllByIdUser(idUser);
    }


    @Override
    public Reclamation save(Reclamation reclamation) {
        // TODO Auto-generated method stub
        return reclamationrepo.save(reclamation);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        reclamationrepo.deleteById(id);
    }
}
