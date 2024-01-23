package com.movie.mynetmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.mynetmovie.model.entity.Award;

public interface AwardRepository extends JpaRepository<Award, Integer>{
    
}
