package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Circus;
import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.enums.City;

import java.time.LocalDate;
import java.util.List;

public interface CircusService {

    Result add(Circus circus);

    DataResult<Circus> getByCircusName(String circusName);
    DataResult<List<Circus>> getAll();
    DataResult<List<Circus>> getByDate(LocalDate date);
    DataResult<List<Circus>> getByCity(City city);
}
