package com.codecrew.fantasticket.entities.eventTypes;

import com.codecrew.fantasticket.enums.City;
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
@Table(name = "circus")
public class Circus {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "circus_id")
    private int id;

    @Column(name = "circus_name")
    private String circusName;

    @Column(name = "circus_description")
    private String circusDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "city")
    private City city;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

}
