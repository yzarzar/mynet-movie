package com.movie.mynetmovie.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mynetmovie.model.entity.Movie;
import com.movie.mynetmovie.repository.MovieRepository;
import com.movie.mynetmovie.service.MovieService;

import lombok.NonNull;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(@NonNull Movie movie) {
        Movie saveMovie = movieRepository.save(movie);
        return saveMovie;
    }

    @Override
    public Movie getMovieById(@NonNull UUID id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        return movieOptional.orElse(null);
    }
    
}
