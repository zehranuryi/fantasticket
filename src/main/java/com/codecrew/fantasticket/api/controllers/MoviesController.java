package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.MovieService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.entities.eventTypes.Movie;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MovieCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private MovieService movieService;


    @Autowired
    public MoviesController(MovieService movieService) {
        super();
        this.movieService = movieService;
    }

    @GetMapping("/getall")
    public DataResult<List<Movie>> getAll(){
        return this.movieService.getAll();
    }

    @GetMapping("/getByMovieName")
    public DataResult<Movie> getByMovieName(@RequestParam String movieName){
        return this.movieService.getByMovieName(movieName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Movie movie) {
        return this.movieService.add(movie);
    }

    @GetMapping("/getByMovieCategory")
    public DataResult<List<Movie>> getByMovieCategory(@RequestParam MovieCategory movieCategory) {
        return this.movieService.getByMovieCategory(movieCategory);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Movie>> getByCity(@RequestParam City city) {
        return this.movieService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Movie>> getByDate(@RequestParam LocalDate date) {
        return this.movieService.getByDate(date);
    }
}
