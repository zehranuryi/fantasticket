package com.codecrew.fantasticket.entities.eventTypes;

import com.codecrew.fantasticket.enums.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "standUp")
public class StandUp {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "standUp_id")
    private int id;

    @Column(name = "standUp_name")
    private String standUpName;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "standUp_description")
    private String standUpDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "city")
    private City city;
}
