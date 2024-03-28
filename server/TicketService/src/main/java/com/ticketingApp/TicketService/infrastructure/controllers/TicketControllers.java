package com.ticketingApp.TicketService.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticketingApp.TicketService.domain.entity.ticket.TicketEntity;
import com.ticketingApp.TicketService.infrastructure.services.TicketServices;

@RestController
@RequestMapping("/api/ticket")
public class TicketControllers {
    
    @Autowired
    private TicketServices ticketServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TicketEntity> getAllTickets() {
        List<TicketEntity> listOfTickets = ticketServices.getAllTickets();

        return listOfTickets;
    }

    @GetMapping("/{ticketId}")
    @ResponseStatus(HttpStatus.OK)
    public TicketEntity getTicketById(@PathVariable String ticketId) {
        TicketEntity ticket = ticketServices.getTicketById(ticketId);

        return ticket;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createTicket(@RequestBody TicketEntity ticketToCreate) {
        String ticketId = ticketServices.createTicket(ticketToCreate);

        if (ticketId == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Creating Ticket");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Ticket created, id: " + ticketId);
    }

    @DeleteMapping("/{ticketId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTicket(@PathVariable String ticketId) {
        boolean isDeleted = ticketServices.deleteTicket(ticketId);

        if (isDeleted) {
            return ResponseEntity.ok("ticket removed, id: " + ticketId);
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing ticket");
    }
}