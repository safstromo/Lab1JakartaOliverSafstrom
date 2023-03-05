package se.iths.lab1jakartaoliversafstrom.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieRepositoryTest {
    @InjectMocks
    private MovieRepository repository;
    @Mock
    private EntityManager entitymanager;
    @Mock
    private Query query;

    Movie movie = new Movie("test", 1);
    Movie movie2 = new Movie("test2", 2);
    List<Movie> movieList = List.of(movie, movie2);

    @Test
    void findOneShouldReturnMovie() {
        when(entitymanager.find(Movie.class, 1L)).thenReturn(movie);

        var result = repository.findOne(1L);
        assertEquals(movie, result.get());
    }

    @Test
    void findAllShouldReturnListOfMovies() {
        when(query.getResultList()).thenReturn(movieList);
        when(entitymanager.createQuery("select m from Movie m")).thenReturn(query);

        var result = repository.findAll();
        assertEquals(movieList, result);
    }

    @Test
    void findByNameShouldReturnTest() {
        var name = "test";
        when(query.getResultList()).thenReturn(List.of(movie));
        when(query.setParameter("name", name + "%")).thenReturn(query);
        when(entitymanager.createQuery("select m from Movie m where name like :name")).thenReturn(query);

        var result = repository.findByName(name);
        assertEquals(List.of(movie), result);
    }

    @Test
    void replaceShouldReturnUpdatedMovie() {
        var upDatedMovie = new Movie("testUpdate", 2);
        when(entitymanager.find(Movie.class, 1L)).thenReturn(movie);
        movie.setId(1L);

        repository.replace(upDatedMovie, 1L);
        assertEquals("testUpdate", movie.getName());
    }

    @Test
    void updateShouldReturnUpdatedMovie() {
        when(entitymanager.find(Movie.class, 2L)).thenReturn(movie2);
        movie2.setId(2L);

        repository.update("TestUpdate2", 2L);
        assertEquals("TestUpdate2", movie2.getName());
    }
}
