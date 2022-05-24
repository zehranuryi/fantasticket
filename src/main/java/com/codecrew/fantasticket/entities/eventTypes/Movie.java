package com.codecrew.fantasticket.entities.eventTypes;

import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MovieCategory;
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
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_description")
    private String movieDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "city")
    private City city;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "movie_category")
    private MovieCategory movieCategory;

}
