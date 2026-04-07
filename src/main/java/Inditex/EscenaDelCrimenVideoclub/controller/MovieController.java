
        package Inditex.EscenaDelCrimenVideoclub.controller;

        import Inditex.EscenaDelCrimenVideoclub.model.Movie;
        import org.springframework.web.bind.annotation.*;
        import Inditex.EscenaDelCrimenVideoclub.service.MovieService;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import java.util.Optional;


        import java.util.List;
        @CrossOrigin(origins = "http://localhost:5173")
        @RestController
        public class MovieController {

            private final MovieService movieService;

            public MovieController(MovieService movieService) {
                this.movieService = movieService;
            }

            @GetMapping("/movies")
            public List<Movie> getAllMovie() {
                return movieService.getAll();
            }

            @PostMapping("/movies")
            public Movie createMovie(@RequestBody Movie newMovie) {
                return movieService.addMovie(newMovie);
            }

            @DeleteMapping("/movies/{id}")
            public void deleteMovieById(@PathVariable int id) {
                movieService.deleteMovie(id);
            }

            @PutMapping("/movies/{id}")
            public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie){
                try{
                    Movie movie = movieService.updateMovie(id, updatedMovie);
                    return new ResponseEntity<>(movie, HttpStatus.OK);
                }
                catch(Exception exception){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            @GetMapping("/movies/ASC")
            public List<Movie> getAllByOrder() {
                return movieService.getAllByOrder();
            }

            @GetMapping("/movies/category/{category}")
            public List<Movie> getByCategory(@PathVariable String category) {
                return movieService.getByCategory(category);
            }

            @GetMapping("/movies/{id}")
            public ResponseEntity<Movie> findMovieById(@PathVariable int id) {
                Optional<Movie> foundMovie = movieService.findMovie(id);
                if (foundMovie.isPresent()) {
                    return new ResponseEntity<>(foundMovie.get(), HttpStatus.FOUND);
                }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }