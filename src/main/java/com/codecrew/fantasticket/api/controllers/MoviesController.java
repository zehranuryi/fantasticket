package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.MovieService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.entities.eventTypes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
