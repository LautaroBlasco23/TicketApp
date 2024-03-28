package com.ticketingApp.UserService.application.services;

import com.ticketingApp.UserService.domain.entity.UserEntity;
import com.ticketingApp.UserService.domain.interfaces.UserInterface;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServices {
    private UserInterface userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserEntity getUserById(String userId) {
        return userRepository.getUserById(userId);
    }

    public UserEntity createUser(UserEntity userData) {
        return userRepository.createUser(userData);
    }

    public boolean modifyUser(String userId, UserEntity userData) {
        return userRepository.modifyUser(userId, userData);
    }

    public boolean deleteUSer(String userId) {
        return userRepository.deleteUSer(userId);
    }
}