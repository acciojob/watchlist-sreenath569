package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {

    MovieService movieService = new MovieService();
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        Movie m = null;
        try{
            m = movieService.addMovie(movie);
            return new ResponseEntity<>("Movie added Successfully.", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        Director d = null;
        try{
            d = movieService.addDirector(director);
            return new ResponseEntity<>("Director successfully added.", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        try{
            movieService.addMovieDirectorPair(movieName, directorName);
            return new ResponseEntity<>("Movie & Director paired successfully.", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//
//    @GetMapping("/movies/get-movie-by-name/{name}")
//    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
//        Movie m = null;
//        try{
//            m = movieService.getMovieByName(name);
//            return ResponseEntity.of(Optional.of(m));
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
