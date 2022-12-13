package com.crud.msstudent.services;

import com.crud.msstudent.models.Participation;
import com.crud.msstudent.models.Payment;

import java.util.List;
import java.util.Optional;

public interface IPayment {

    List<Payment> getAll();

    Optional<Payment> findById(int id);

    List<Payment> findAllByIdUser(int idUser);
    Payment save(Payment payment);

    void deleteById(int id);
    
}
