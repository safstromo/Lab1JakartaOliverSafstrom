package se.iths.lab1jakartaoliversafstrom.dto;

import jakarta.enterprise.context.ApplicationScoped;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;

import java.util.List;

@ApplicationScoped
public class Mapper {


    public List<MovieDto> mapMovieToDto(List<Movie> movie){
        return movie.stream().map(MovieDto::new).toList();
    }
}
