package movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity(name="movie")
public class Movie {

    @Id
    private String imdbId;
    private String tittle;
    private String movieYear;
    private String genre;

    public Movie(String imdbId, String tittle, String movieYear, String genre) {
        this.imdbId = imdbId;
        this.tittle = tittle;
        this.movieYear = movieYear;
        this.genre = genre;
    }

    public Movie() {

    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
