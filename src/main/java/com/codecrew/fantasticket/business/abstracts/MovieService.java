package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Movie;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MovieCategory;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    Result add(Movie movie);
    DataResult<Movie> getByMovieName(String movieName);
    DataResult<List<Movie>> getAll();
    DataResult<List<Movie>> getByMovieCategory(MovieCategory movieCategory);
    DataResult<List<Movie>> getByDate(LocalDate date);
    DataResult<List<Movie>> getByCity(City city);
}
