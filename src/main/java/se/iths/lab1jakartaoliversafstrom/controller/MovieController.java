package se.iths.lab1jakartaoliversafstrom.controller;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.validation.constraints.Past;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;
import se.iths.lab1jakartaoliversafstrom.repository.MovieRepository;

import java.util.List;

@Path("/movies")
public class MovieController {
    @Inject
    MovieRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll() {

        return repository.findAll();
    }


}
