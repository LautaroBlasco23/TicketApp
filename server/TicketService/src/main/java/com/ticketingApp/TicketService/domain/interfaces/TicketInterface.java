package com.ticketingApp.TicketService.domain.interfaces;

import java.util.List;

import com.ticketingApp.TicketService.domain.entity.ticket.TicketEntity;

public interface TicketInterface {
    public List<TicketEntity> getAllTickets();
    public TicketEntity getTicketById(String ticketId);
    public String createTicket(TicketEntity ticketToCreate);
    public boolean deleteTicket(String ticketId);
}