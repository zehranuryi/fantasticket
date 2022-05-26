package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.MovieService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.MovieDao;
import com.codecrew.fantasticket.entities.eventTypes.Movie;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MovieCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                    (this.movieDao.findAll(),"Movies listed.");

        }

        @Override
        public Result add(Movie movie) {
            this.movieDao.save(movie);
            return new SuccessResult("Movie added.");
        }

       @Override
       public DataResult<Movie> getByMovieName(String movieName) {
            return new SuccessDataResult<Movie>
                    (this.movieDao.getByMovieName(movieName),"Movie listed.");
       }

    @Override
    public DataResult<List<Movie>> getByMovieCategory(MovieCategory movieCategory) {
        return new SuccessDataResult<List<Movie>>
                (this.movieDao.getByMovieCategory(movieCategory),"Movies listed.");
    }

    @Override
    public DataResult<List<Movie>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Movie>>
                (this.movieDao.getByDate(date),"Movies listed.");
    }

    @Override
    public DataResult<List<Movie>> getByCity(City city) {
        return new SuccessDataResult<List<Movie>>
                (this.movieDao.getByCity(city),"Movies listed.");
    }
}
