package com.codecrew.fantasticket.entities.eventTypes;

import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MusicType;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "concert")
public class Concert {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "concert_id")
    private int id;

    @Column(name = "concert_name")
    private String concertName;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "concert_description")
    private String concertDescription;

    @Column(name = "venue")
    private String venue;

    @Column(name = "city")
    private City city;

    @Column(name = "date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime time;

    @Column(name = "music_type")
    private MusicType musicType;
}
