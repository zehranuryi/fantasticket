package com.codecrew.fantasticket.entities;

import com.codecrew.fantasticket.enums.Events;
import com.codecrew.fantasticket.enums.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int Id;

    @Column(name = "event_type")
    private Events event;

    @Column(name = "ticket_type")
    private TicketType ticketType;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "unit_in_stock")
    private int unitsInStock;

    @Column(name = "purchased")
    private int purchasedTicket;

    @Column(name = "not_purchased")
    private int notPurchasedTicket;

}
