package movie.controller;


import movie.model.Movie;
import movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieCotroller {

    private final MovieService movieService;

    public MovieCotroller(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Movie> getMovie(@PathVariable String name){
        return ResponseEntity.ok(movieService.movieConsult(name));
    }
}
