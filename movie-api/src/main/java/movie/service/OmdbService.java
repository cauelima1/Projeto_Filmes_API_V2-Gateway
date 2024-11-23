package movie.service;

import movie.model.DTOs.OmdbDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "OMDB", url = "http://www.omdbapi.com/")
public interface OmdbService {

    @GetMapping("/?apikey=62d3e3f1&t={nome}")
    OmdbDTO consultMovie(@PathVariable("nome") String nome);
}
