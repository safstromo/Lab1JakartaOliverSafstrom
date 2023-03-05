package se.iths.lab1jakartaoliversafstrom.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.iths.lab1jakartaoliversafstrom.dto.Mapper;
import se.iths.lab1jakartaoliversafstrom.dto.MovieDto;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;
import se.iths.lab1jakartaoliversafstrom.repository.MovieRepository;

import java.net.URI;
import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {
    @Inject
    MovieRepository repository;
    @Inject
    Mapper mapper;

    @GET
    public List<MovieDto> getAll(@QueryParam("name") String name) {
        if (name == null)
            return mapper.mapMovieToDto(repository.findAll());
        return mapper.mapMovieToDto(repository.findByName(name));
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        var movie = repository.findOne(id);
        if (movie.isPresent())
            return Response.ok().entity(mapper.mapMovieToDto(movie).get()).build();
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid Movie movie) {
        repository.add(movie);
        return Response.created(URI.create("/movies/" + movie.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        repository.delete(id);
        return Response.ok().build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateName(@PathParam("id") Long id, MovieDto movieDto) {
        repository.update(movieDto.getName(), id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response replace(@PathParam("id") Long id, @Valid Movie movie) {
        if (repository.findOne(id).isPresent()) {
            repository.replace(movie, id);
            return Response.created(URI.create("/movies/" + id)).build();
        }
        return Response.noContent().build();
    }
}

