package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Movie;;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow() {
        Movie entity = springJdbcRepository.get("movieA1");
        return new ResponseEntity("Movie: " + entity.getMovieId()
                + ", " + entity.getMovieName(), HttpStatus.OK);
    }

    public ResponseEntity<String> insert() {
        Movie movie = new Movie("movieA2","RRR",2020,4.7f);
        springJdbcRepository.add(movie);
        return new ResponseEntity("movie Add: " + movie.getMovieId()
                + ", " + movie.getMovieName()+","+movie.getYear()+","+movie.getRatings(), HttpStatus.OK);
    }

      public ResponseEntity<String> read() {
      Movie movie = springJdbcRepository.get("");
       return new ResponseEntity("Movie Get: " + movie.getMovieId()
                + ", " + movie.getMovieName()+","+movie.getYear()+","+movie.getRatings(), HttpStatus.OK);
   }

    public ResponseEntity<String> update() {
        Movie movie = new Movie("movieA1", "maharshi",2019,4.3f);
        springJdbcRepository.update(movie);
        return new ResponseEntity("Movie Update: " + movie.getMovieId()
                + ", " + movie.getMovieName()+","+movie.getYear()+","+movie.getRatings(), HttpStatus.OK);
    }

    public ResponseEntity<String> delete() {
        Movie movie= new Movie("movieA1");
        springJdbcRepository.delete(movie);
        return new ResponseEntity("Movie Delete: " + movie.getMovieId()
                + ", " + movie.getMovieName()+","+movie.getYear()+","+movie.getRatings(), HttpStatus.OK);
    }
    public ResponseEntity<?> getAll() {
        List<Movie> movieList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }
}
