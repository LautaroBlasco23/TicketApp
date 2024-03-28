package com.ticketingApp.TicketService.infrastructure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ticketingApp.TicketService.domain.entity.ticket.TicketEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@SuperBuilder
@Document(collection = "tickets")
public class Ticket extends TicketEntity {
    @Id
    private String id;
}
