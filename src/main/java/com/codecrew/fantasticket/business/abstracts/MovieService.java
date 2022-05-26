package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.entities.eventTypes.Movie;

import java.util.List;

public interface MovieService {
    DataResult<List<Movie>> getAll();
}
