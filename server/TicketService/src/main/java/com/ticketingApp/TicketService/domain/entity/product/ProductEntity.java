package com.ticketingApp.TicketService.domain.entity.product;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductEntity {
    protected String name;
    protected BigDecimal price;
    protected int quantity;
}
