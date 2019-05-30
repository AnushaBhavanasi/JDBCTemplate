package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {
    private JdbcTemplate jdbcTemplate ;

    public SpringJdbcRepository(){
    }

    @Autowired
    public void  setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll() {

        return jdbcTemplate.query("select * from movieTable", new MovieRowMapper());
    }
    public int add(Movie movie) {
        return jdbcTemplate.update("INSERT INTO movieTable VALUES (?, ?,?,?)", movie.getMovieId(), movie.getMovieName(),movie.getYear(),movie.getRatings());
    }

    public Movie get(final String id) {
        final String query = "select ratings from movieTable where movieId=? ";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new MovieRowMapper());
    }

    public int update(Movie movie) {
        return jdbcTemplate.update("update movieTable SET ratings=? WHERE movieId=? AND movieName=? AND releaseyear=?", movie.getRatings(), movie.getMovieId(),movie.getMovieName(),movie.getYear());
    }


    public int delete(Movie movie) {
        return jdbcTemplate.update("delete from movieTable where movieId=? ",movie.getMovieId());
    }

}
