package com.tusharjoshi.fullstackbackend.controller;
import com.tusharjoshi.fullstackbackend.exception.UserNotFoundException;
import com.tusharjoshi.fullstackbackend.model.User;
import com.tusharjoshi.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)); }

        @PutMapping("/user/{id}")
                User updateUser(@RequestBody User newUser, @PathVariable Long id){
            return userRepository.findById(id)
                    .map(user -> {
                        user.setName(newUser.getName());
                        user.setUsername(newUser.getUsername());
                        user.setEmail(newUser.getEmail());
                        return userRepository.save(user);
                    }).orElseThrow(()-> new UserNotFoundException(id));
        }

}
