package com.ticketingApp.TicketService.domain.entity.ticket;

import java.util.List;

import com.ticketingApp.TicketService.domain.entity.product.ProductEntity;
import com.ticketingApp.TicketService.domain.entity.user.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class TicketEntity {
    protected UserEntity user;
    protected List<ProductEntity> listOfProducts;
}
