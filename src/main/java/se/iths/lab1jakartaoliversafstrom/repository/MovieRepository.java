package se.iths.lab1jakartaoliversafstrom.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;


    public Optional<Movie> findOne(Long id) {
        return Optional.ofNullable(entityManager.find(Movie.class, id));
    }


    public List<Movie> findAll() {
        var query = entityManager.createQuery("select m from Movie m");
        return query.getResultList();

    }

    public List<Movie> findByName(String name) {
        var query = entityManager.createQuery("select m from Movie m where name like :name");
        query.setParameter("name", name + "%");
        return query.getResultList();
    }

    public void add(Movie movie) {
        entityManager.persist(movie);
    }

    public void delete(Long id) {
        findOne(id).ifPresent((movie) -> entityManager.remove(movie));
    }

    public void update(String newName, Long id){
       findOne(id).ifPresent((movie)-> movie.setName(newName));
    }
}
