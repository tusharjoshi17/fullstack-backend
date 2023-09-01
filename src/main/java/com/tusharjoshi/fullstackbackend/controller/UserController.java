package com.tusharjoshi.fullstackbackend.controller;
import com.tusharjoshi.fullstackbackend.model.User;
import com.tusharjoshi.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
}
