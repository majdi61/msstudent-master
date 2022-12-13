package com.crud.msstudent.services;

import com.crud.msstudent.models.Camping;
import com.crud.msstudent.repositories.CampingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampingService implements ICamping {

    CampingRepository campingrepo;

    @Autowired
    public CampingService(CampingRepository campingrepo) {
        this.campingrepo = campingrepo;
    }

    @Override
    public List<Camping> getAllCampings() {
        // TODO Auto-generated method stub
        return campingrepo.findAll();
    }

    @Override
    public Optional<Camping> findById(int id) {
        // TODO Auto-generated method stub
        return campingrepo.findById(id);
    }

    @Override
    public List<Camping> findAllByEtat(int etat) {
        // TODO Auto-generated method stub
        return campingrepo.findAllByEtat(etat);
    }

    @Override
    public List<Camping> findAllByIdOrganisateur(int id) {
        // TODO Auto-generated method stub
        return campingrepo.findAllByIdOrganisateur(id);
    }

    @Override
    public Camping save(Camping std) {
        // TODO Auto-generated method stub
        return campingrepo.save(std);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        campingrepo.deleteById(id);
    }
}
