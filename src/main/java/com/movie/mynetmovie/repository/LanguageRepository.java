package com.movie.mynetmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.mynetmovie.model.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    
}
