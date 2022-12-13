package com.crud.msstudent.repositories;

import com.crud.msstudent.models.Reclamation;
import com.crud.msstudent.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
    // Query method
 //   Optional<Camping> findByEmail(String email);


    Optional<User> findByEmailAndMotPasse(String email,String motPasse);
}
