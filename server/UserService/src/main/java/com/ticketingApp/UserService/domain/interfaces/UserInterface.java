package com.ticketingApp.UserService.domain.interfaces;

import java.util.List;
import com.ticketingApp.UserService.domain.entity.UserEntity;

public interface UserInterface {
    public List<UserEntity> getAllUsers();
    public UserEntity getUserById(String userId);
    public UserEntity createUser(UserEntity userData);
    public boolean modifyUser(String userId, UserEntity userData);
    public boolean deleteUSer(String userId);
}