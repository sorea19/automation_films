package com.backend.automationfilms;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

import com.backend.automationfilms.*;

// This will be AUTO IMPLEMENTED by Spring into a Bean called filmRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Nominated, Integer> {
    @Query("SELECT n FROM Nominated n WHERE n.awardCategory = ?1 AND n.movie = ?2")
    Collection<Nominated> findNominationByAwardAndMovie(AwardCategory award, Movie movie);
}
