package se.iths.lab1jakartaoliversafstrom.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;

}
