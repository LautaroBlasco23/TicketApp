package com.ticketingApp.UserService.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.ticketingApp.UserService.application.services.UserServices;
import com.ticketingApp.UserService.domain.entity.UserEntity;

@RestController
@RequestMapping("/api/user")
public class UserControllers {
    
    @Autowired
    private UserServices userServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity getUserById(@PathVariable String userId) {
        return userServices.getUserById(userId);
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity userData) {
        return userServices.createUser(userData);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> modifyUser(@PathVariable String userId, @RequestBody UserEntity userData) {
        if (userServices.modifyUser(userId, userData)) {
            return ResponseEntity.status(HttpStatus.OK).body("user with id: " + userId + " has been modified");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error modifying user");
        }
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        if (userServices.deleteUSer(userId)) {
            return ResponseEntity.status(HttpStatus.OK).body("user with id: " + userId + " has been modified");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error modifying user");
        }
    }
}