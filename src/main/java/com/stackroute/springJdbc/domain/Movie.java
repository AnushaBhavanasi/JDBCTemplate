package com.stackroute.springJdbc.domain;

public class Movie{
    private String movieId;
    private  String movieName;
    private int year;
    private float ratings;

    public Movie(String movieId) {
        this.movieId = movieId;
    }

    public Movie(float ratings , String movieId) {
        this.ratings = ratings;
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public Movie() {
    }

    public Movie(String movieId, String movieName, int year, float ratings) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.year = year;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", year=" + year +
                ", ratings=" + ratings +
                '}';
    }
}

