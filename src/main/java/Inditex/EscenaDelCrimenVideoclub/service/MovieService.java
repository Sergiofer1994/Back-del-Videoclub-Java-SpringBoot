package Inditex.EscenaDelCrimenVideoclub.service;


import Inditex.EscenaDelCrimenVideoclub.model.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Inditex.EscenaDelCrimenVideoclub.repository.MovieRepository;


import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie newMovie){
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(int id){
        movieRepository.deleteById(id);
    }
    public Optional<Movie> findMovie(int id){
        return movieRepository.findById(id);
    }

    public Movie updateMovie(int id, Movie updatedMovie){

        //verificamos que aun existe la pelicula despues de rellenar el formulario
        Optional<Movie> foundMovie = movieRepository.findById(id);

        if(foundMovie.isPresent()){
            Movie existingMovie = foundMovie.get();

            //Actualizamos los campos
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setYear(updatedMovie.getYear());
            existingMovie.setDirector(updatedMovie.getDirector());
            existingMovie.setMain_cast(updatedMovie.getMain_cast());
            existingMovie.setFilmaffinity_score(updatedMovie.getFilmaffinity_score());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setImg(updatedMovie.getImg());
            existingMovie.setUrl(updatedMovie.getUrl());
            existingMovie.setTrailer(updatedMovie.getTrailer());
            existingMovie.setRanking(updatedMovie.getRanking());
            existingMovie.setCategory(updatedMovie.getCategory());
            //guardar la pelicula
            return movieRepository.save(existingMovie);
        }

        //si no existe la pelicula, enviar un mensaje de error al usuario
        throw new RuntimeException("Movie not found in DDBB with id : " + id);
    }


    public List<Movie> getAllByOrder(){
        return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    public List<Movie> getByCategory(String category){
        return movieRepository.findByCategory(category);
    }


}