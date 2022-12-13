package com.crud.msstudent.repositories;

import com.crud.msstudent.models.Camping;
import com.crud.msstudent.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Integer> {
	
    // Query method
 //   Optional<Camping> findByEmail(String email);

    List<Camping> findAllByEtat(int etat);

    List<Camping> findAllByIdOrganisateur(int idOrganisateur);
}
