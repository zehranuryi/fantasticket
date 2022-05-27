package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Theater;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.TheaterType;

import java.time.LocalDate;
import java.util.List;

public interface TheaterService {

    Result add(Theater theater);

    DataResult<Theater> getByTheaterName(String theaterName);

    DataResult<List<Theater>> getAll();
    DataResult<List<Theater>> getByTheaterType(TheaterType theaterType);
    DataResult<List<Theater>> getByDate(LocalDate date);
    DataResult<List<Theater>> getByCity(City city);
}
