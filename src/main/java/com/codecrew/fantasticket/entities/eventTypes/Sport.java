package com.codecrew.fantasticket.entities.eventTypes;

import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MatchCategory;
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
@Table(name = "sport")
public class Sport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int id;

    @Column(name = "first_team_name")
    private String firstTeamName;

    @Column(name = "second_team_name")
    private String secondTeamName;

    @Column(name = "match_category")
    private MatchCategory matchCategory;

    @Column(name = "match_description")
    private String matchDescription;

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
}
