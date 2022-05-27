package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.StandUp;
import com.codecrew.fantasticket.enums.City;

import java.time.LocalDate;
import java.util.List;

public interface StandUpService {

    Result add(StandUp standUp);

    DataResult<List<StandUp>> getAll();

    DataResult<StandUp> getByStandUpName(String standUpName);

    DataResult<List<StandUp>> getByArtistName(String artistName);
    DataResult<List<StandUp>> getByDate(LocalDate date);
    DataResult<List<StandUp>> getByCity(City city);
}
