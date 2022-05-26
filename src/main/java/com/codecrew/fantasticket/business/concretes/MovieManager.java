package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.MovieService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.dataAccess.abstracts.MovieDao;
import com.codecrew.fantasticket.entities.eventTypes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieManager implements MovieService {

        private MovieDao movieDao;

        @Autowired
        public MovieManager(MovieDao movieDao) {
            super();
            this.movieDao = movieDao;
        }

        @Override
        public DataResult<List<Movie>> getAll() {

            return new SuccessDataResult<List<Movie>>
                    (this.movieDao.findAll(),"Movies listed");

        }
}
