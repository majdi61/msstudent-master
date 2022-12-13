package com.crud.msstudent.controllers;

import com.crud.msstudent.exceptions.UserNotFoundException;
import com.crud.msstudent.models.User;
import com.crud.msstudent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userservice.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") @Min(1) int id) {
        User std = userservice.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with " + id + " is Not Found!"));
        return std;
    }

    @GetMapping(value = "/login")
    public User findByEmailAndMotPasse(@RequestBody User userx) {
        User user = userservice.findByEmailAndMotPasse(userx.getEmail(),userx.getMotPasse())
                .orElseThrow(() -> new UserNotFoundException("User with " + userx.getEmail() + " is Not Found!"));
        return user;
    }

    @PostMapping(value = "/")
    public User addUser(@Valid @RequestBody User user) {
        return userservice.save(user);
    }

    @PostMapping(value = "/{id}")
    public User updateUser(@PathVariable("id") @Min(1) int id, @Valid @RequestBody User user) {
        return userservice.save(user);
    }



    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") @Min(1) int id) {
        User user = userservice.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with " + id + " is Not Found!"));
        userservice.deleteById(user.getId_user());
        return "User with ID :" + id + " is deleted";
    }
}
