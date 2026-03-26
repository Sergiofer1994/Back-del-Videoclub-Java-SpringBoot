
        package Inditex.EscenaDelCrimenVideoclub.controller;

import Inditex.EscenaDelCrimenVideoclub.model.Movie;
import org.springframework.web.bind.annotation.*;
import service.MovieService;


import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public <MovieService> MovieController(MovieService movieService) {
        this.movieService = (service.MovieService) movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovie(){
        return movieService.getAll();
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie newMovie){
        return movieService.addMovie(newMovie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable int id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/movies/ASC")
    public List<Movie> getAllByOrder(){
        return movieService.getAllByOrder();
    }
}