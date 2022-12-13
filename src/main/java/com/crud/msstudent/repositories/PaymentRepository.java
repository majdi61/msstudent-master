package com.crud.msstudent.repositories;

import com.crud.msstudent.models.Participation;
import com.crud.msstudent.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
    // Query method
 //   Optional<Camping> findByEmail(String email);

    List<Payment> findAllByIdUser(int idUser);
}
