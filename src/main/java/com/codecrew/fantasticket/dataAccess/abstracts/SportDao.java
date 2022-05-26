package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Sport;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MatchCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SportDao extends JpaRepository<Sport, Integer> {

    List<Sport> getByMatchCategory(MatchCategory matchCategory);
    List<Sport> getByDate(LocalDate date);
    List<Sport> getByCity(City city);
}
