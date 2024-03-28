package com.ticketingApp.TicketService.domain.entity.user;

import lombok.Data;

@Data
public class UserEntity {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
}
