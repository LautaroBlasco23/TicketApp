package com.ticketingApp.TicketService.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.ticketingApp.TicketService.infrastructure.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {
}