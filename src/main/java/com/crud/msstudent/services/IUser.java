package com.crud.msstudent.services;

import com.crud.msstudent.models.Payment;
import com.crud.msstudent.models.User;

import java.util.List;
import java.util.Optional;

public interface IUser {

    List<User> getAll();

    Optional<User> findById(int id);
    Optional<User> findByEmailAndMotPasse(String Email, String motpasse );
    User save(User user);

    void deleteById(int id);
    
}
