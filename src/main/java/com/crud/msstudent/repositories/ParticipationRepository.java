package com.crud.msstudent.repositories;

import com.crud.msstudent.models.Camping;
import com.crud.msstudent.models.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
	
    // Query method
 //   Optional<Camping> findByEmail(String email);

    List<Participation> findParticipationByIdParticipant(int idparticipant);
}
