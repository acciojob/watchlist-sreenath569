package com.driver;

import java.util.HashMap;

public class MovieRepository {

    HashMap<String, Movie> movieNameToMovie = new HashMap<>();
    HashMap<String, Director> directorNameToDirector = new HashMap<>();
    HashMap<String, String> movieToDirector = new HashMap<>();

    public Movie addMovie(Movie movie){
        movieNameToMovie.put(movie.getName(), movie);
        return movie;
    }

    public Director addDirector(Director director){
        directorNameToDirector.put(director.getName(), director);
        return director;
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        movieToDirector.put(movieName, directorName);
    }
//
//    public Movie getMovieByName(String movieName){
//        return movieNameToMovie.get(movieName);
//    }
}
