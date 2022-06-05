package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.service.MovieService;
import com.codecrew.fantasticket.exceptions.DataResult;
import com.codecrew.fantasticket.exceptions.SuccessDataResult;
import com.codecrew.fantasticket.dao.MovieDao;
import com.codecrew.fantasticket.entity.eventTypes.Movie;
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