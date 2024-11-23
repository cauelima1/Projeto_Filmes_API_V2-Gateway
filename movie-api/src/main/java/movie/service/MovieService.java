package movie.service;

import movie.model.DTOs.OmdbDTO;
import movie.model.Movie;
import movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private OmdbService omdbService;

    @Autowired
    private MovieRepository movieRepository;

    public Movie movieConsult(String name){
        OmdbDTO omdbDTO = omdbService.consultMovie(name);
        if(!movieRepository.existsById(omdbDTO.getImdbID())){
            Movie newMovie = new Movie();
            newMovie.setImdbId(omdbDTO.getImdbID());
            newMovie.setTittle(omdbDTO.getTitle());
            newMovie.setMovieYear(omdbDTO.getMovieYear());
            newMovie.setGenre(omdbDTO.getGenre());

            return movieRepository.save(newMovie);
    }
        return null;
    }

}
