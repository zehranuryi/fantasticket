package com.codecrew.fantasticket.entities.eventTypes;

import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.TheaterType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private int id;

    @Column(name = "theater_name")
    private String theaterName;

    @Column(name = "theater_description")
    private String theaterDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "city")
    private City city;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "theater_type")
    private TheaterType theaterType;


}
