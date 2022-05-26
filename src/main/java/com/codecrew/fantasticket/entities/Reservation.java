package com.codecrew.fantasticket.entities;

import com.codecrew.fantasticket.enums.Events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @JoinColumn(name = "user_id")
    private int customerId;

    @Column(name = "event_type")
    private Events event;

    @Column(name = "event_id")
    private int eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "reservation_date_time")
    private LocalDateTime ReservationDateTime;

    @Column(name = "total_payment")
    private double totalPayment;
}
