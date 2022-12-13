package com.crud.msstudent.controllers;

import com.crud.msstudent.exceptions.PaymentNotFoundException;
import com.crud.msstudent.models.Payment;
import com.crud.msstudent.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    PaymentService paymentservice;

    @Autowired
    public PaymentController(PaymentService paymentservice) {
        this.paymentservice = paymentservice;
    }

    @GetMapping(value = "/")
    public List<Payment> getAllPayments() {
        return paymentservice.getAll();
    }
    @GetMapping(value = "/idUser/{id}")
    public List<Payment> findAllByIdUser(@PathVariable("id") @Min(1) int id) {
        return paymentservice.findAllByIdUser(id);
    }

    @GetMapping(value = "/{id}")
    public Payment getPaymentById(@PathVariable("id") @Min(1) int id) {
        Payment std = paymentservice.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping(value = "/")
    public Payment addPayment(@Valid @RequestBody Payment payment) {
        return paymentservice.save(payment);
    }

    @PostMapping(value = "/{id}")
    public Payment updatePayment(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Payment payment) {
        return paymentservice.save(payment);
    }

    @DeleteMapping(value = "/{id}")
    public String deletePayment(@PathVariable("id") @Min(1) int id) {
        Payment payment = paymentservice.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with " + id + " is Not Found!"));
        paymentservice.deleteById(payment.getId_payment());
        return "Payment with ID :" + id + " is deleted";
    }
}
