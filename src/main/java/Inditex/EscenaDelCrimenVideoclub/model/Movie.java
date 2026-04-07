package Inditex.EscenaDelCrimenVideoclub.model;

import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int year;
    private String director;
    private String main_cast;
    @Column(name = "film_affinity_score")
    private double filmaffinity_score;
    private String description;
    private String img;
    private String url;
    private String trailer;
    private double ranking;
    private String category;


    public Movie() {}

    public Movie(String title, int year, String director, String main_cast, double filmaffinity_score, String description, String img, String url, double ranking, String category) {
        this.title = title;
        this.year = year;
        this.main_cast = main_cast;
        this.director = director;
        this.filmaffinity_score = filmaffinity_score;
        this.description = description;
        this.img = img;
        this.url = url;
        this.ranking = ranking;
        this.category = category;
    }
    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMain_cast() {
        return main_cast;
    }

    public void setMain_cast(String main_cast) {
        this.main_cast = main_cast;
    }

    public double getFilmaffinity_score() {
        return filmaffinity_score;
    }

    public void setFilmaffinity_score(double filmaffinity_score) {
        this.filmaffinity_score = filmaffinity_score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}