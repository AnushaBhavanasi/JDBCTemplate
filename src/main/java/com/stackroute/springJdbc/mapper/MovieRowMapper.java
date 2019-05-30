package com.stackroute.springJdbc.mapper;
import com.stackroute.springJdbc.domain.Movie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
         Movie movie = new Movie();
         movie.setMovieId(resultSet.getString(1));
         movie.setMovieName(resultSet.getString(2));
         movie.setYear(resultSet.getInt(3));
         movie.setRatings(resultSet.getFloat(4));
         return movie;
    }
}
