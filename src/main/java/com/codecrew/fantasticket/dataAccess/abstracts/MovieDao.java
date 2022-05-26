package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Movie;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    Movie getByMovieName(String movieName);

    List<Movie> getByMovieCategory(MovieCategory movieCategory);
    List<Movie> getByDate(LocalDate date);
    List<Movie> getByCity(City city);
}
