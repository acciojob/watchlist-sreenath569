package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap = new HashMap<>();
    private HashMap<String, Director> directorMap = new HashMap<>();
    private HashMap<String, List<String>> movieDirectorMap = new HashMap<>();

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){

        List<String> currentMoviesByDirector = new ArrayList<>();
        if(movieDirectorMap.containsKey(directorName)){
            currentMoviesByDirector = movieDirectorMap.get(directorName);
        }
        currentMoviesByDirector.add(movieName);
        movieDirectorMap.put(directorName, currentMoviesByDirector);
    }

    public Movie getMovieByName(String movieName){
        return movieMap.get(movieName);
    }

    public Director getDirectorByName(String directorName){
        return directorMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return movieDirectorMap.get(directorName);
    }

    public List<String> findAllMovies(){
        List<String> moviesList = new ArrayList<>(movieMap.keySet());
        return moviesList;
    }

    public void removeDirectorFromDirectorMap(String directorName){
        directorMap.remove(directorName);
    }

    public void removeDirectorFromMovieDirectorMap(String directorName){
        movieDirectorMap.remove(directorName);
    }

    public void removeMovie(String movieName){
        movieMap.remove(movieName);
    }

    public List<String> getAllDirectors(){
        return new ArrayList<>(directorMap.keySet());
    }
    public boolean isMoviePresent(String movieName){
        return movieMap.containsKey(movieName);
    }

    public boolean isDirectorPresent(String directorName){
        return directorMap.containsKey(directorName);
    }


}
