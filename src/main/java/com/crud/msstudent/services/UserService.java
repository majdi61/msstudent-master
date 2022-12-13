package com.crud.msstudent.services;

import com.crud.msstudent.models.User;
import com.crud.msstudent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUser {

    UserRepository userrepo;

    @Autowired
    public UserService(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return userrepo.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        // TODO Auto-generated method stub
        return userrepo.findById(id);
    }
    @Override
    public Optional<User> findByEmailAndMotPasse(String email,String motPasse) {
        // TODO Auto-generated method stub
        return userrepo.findByEmailAndMotPasse(email,motPasse);
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        return userrepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        userrepo.deleteById(id);
    }
}
