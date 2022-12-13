package com.crud.msstudent.services;

import com.crud.msstudent.models.Participation;
import com.crud.msstudent.models.Payment;
import com.crud.msstudent.repositories.ParticipationRepository;
import com.crud.msstudent.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPayment {

    PaymentRepository paymentrepo;

    @Autowired
    public PaymentService(PaymentRepository paymentrepo) {
        this.paymentrepo = paymentrepo;
    }

    @Override
    public List<Payment> getAll() {
        // TODO Auto-generated method stub
        return paymentrepo.findAll();
    }

    @Override
    public Optional<Payment> findById(int id) {
        // TODO Auto-generated method stub
        return paymentrepo.findById(id);
    }

    @Override
    public List<Payment> findAllByIdUser(int idUser) {
        return  paymentrepo.findAllByIdUser(idUser);
    }

    @Override
    public Payment save(Payment payment) {
        // TODO Auto-generated method stub
        return paymentrepo.save(payment);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        paymentrepo.deleteById(id);
    }
}
