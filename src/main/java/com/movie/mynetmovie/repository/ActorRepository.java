package com.movie.mynetmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.mynetmovie.model.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
    
}
