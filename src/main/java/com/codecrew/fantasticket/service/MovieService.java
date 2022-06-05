package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.exceptions.DataResult;
import com.codecrew.fantasticket.entity.eventTypes.Movie;

import java.util.List;

public interface MovieService {
    DataResult<List<Movie>> getAll();
}