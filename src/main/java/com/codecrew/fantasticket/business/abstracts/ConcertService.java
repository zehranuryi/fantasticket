package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MusicType;

import java.time.LocalDate;
import java.util.List;

public interface ConcertService {

    Result add(Concert concert);

    DataResult<List<Concert>> getAll();

    DataResult<Concert> getByConcertName(String concertName);

    DataResult<List<Concert>> getByMusicType(MusicType musicType);
    DataResult<List<Concert>> getByArtistName(String artistName);
    DataResult<List<Concert>> getByDate(LocalDate date);
    DataResult<List<Concert>> getByCity(City city);
}
