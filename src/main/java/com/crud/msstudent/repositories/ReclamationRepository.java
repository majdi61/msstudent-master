package com.crud.msstudent.repositories;

import com.crud.msstudent.models.Payment;
import com.crud.msstudent.models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
	

    List<Reclamation> findAllByIdUser(int idUser);
}
