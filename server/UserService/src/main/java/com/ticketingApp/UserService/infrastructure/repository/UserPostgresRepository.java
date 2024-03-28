package com.ticketingApp.UserService.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticketingApp.UserService.infrastructure.model.UserModel;

@Repository
public interface UserPostgresRepository extends CrudRepository<UserModel, Long> {
}