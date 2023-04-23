package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();
    public Movie addMovie(Movie movie){
        movieRepository.addMovie(movie);
        return movie;
    }

    public Director addDirector(Director director){
        movieRepository.addDirector(director);
        return director;
    }

    public void addMovieDirectorPair(String movieName, String directorName){

        if(movieRepository.movieNameToMovie.containsKey(movieName) && movieRepository.directorNameToDirector.containsKey(directorName)){
            movieRepository.addMovieDirectorPair(movieName, directorName);
        }
    }
//
//    public Movie getMovieByName(String movieName){
//        return movieRepository.getMovieByName(movieName);
//    }
}
