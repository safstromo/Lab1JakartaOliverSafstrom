package se.iths.lab1jakartaoliversafstrom.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.iths.lab1jakartaoliversafstrom.entity.Movie;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;



    public Optional<Movie> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Movie.class, id));
    }



    public List<Movie> findAll(){
        var query = entityManager.createQuery("select m from Movie m");
        return query.getResultList();

    }

    public void add(Movie movie){
        entityManager.persist(movie);
    }

    public void delete(){}

    public void update(){}
}
