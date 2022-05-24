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
@Table(name = "workshop")
public class Workshop {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private int id;

    @Column(name = "workshop_name")
    private String workshopName;

    @Column(name = "workshop_description")
    private String workshopDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "city")
    private City city;

}
