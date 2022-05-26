package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MusicType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConcertDao extends JpaRepository<Concert, Integer> {

    Concert getByConcertName(String concertName);

    List<Concert> getByArtistName(String artistName);
    List<Concert> getByMusicType(MusicType musicType);
    List<Concert> getByDate(LocalDate date);
    List<Concert> getByCity(City city);
}

