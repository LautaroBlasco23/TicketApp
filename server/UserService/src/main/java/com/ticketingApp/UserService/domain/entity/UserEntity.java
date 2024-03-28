package com.ticketingApp.UserService.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class UserEntity {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
}
