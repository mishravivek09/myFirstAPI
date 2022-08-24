package com.vivek.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.movies.model.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Long>{

}
