package com.movie.mynetmovie.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.mynetmovie.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, UUID>{
    
}
