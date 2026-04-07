package Inditex.EscenaDelCrimenVideoclub.repository;
import Inditex.EscenaDelCrimenVideoclub.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByCategory(String category);
}