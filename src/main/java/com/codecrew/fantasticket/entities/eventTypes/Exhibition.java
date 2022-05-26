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
@Table(name = "exhibition")
public class Exhibition {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "exhibition_id")
    private int id;

    @Column(name = "exhibition_name")
    private String exhibitionName;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "exhibition_description")
    private String exhibitionDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "city")
    private City city;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;
}

