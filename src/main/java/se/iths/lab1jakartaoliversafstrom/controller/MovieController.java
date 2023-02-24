package se.iths.lab1jakartaoliversafstrom.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;
import se.iths.lab1jakartaoliversafstrom.repository.MovieRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {
    @Inject
    MovieRepository repository;

    @GET
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @GET
    @Path("/{id}")
    public Optional<Movie> getOne(@PathParam("id") Long id) {
        return repository.findOne(id);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid Movie movie){
        repository.add(movie);
        return Response.created(URI.create("/movies/" + movie.getId())).build();
    }

}

