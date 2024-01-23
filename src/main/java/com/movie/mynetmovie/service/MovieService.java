package com.movie.mynetmovie.service;

import java.util.UUID;

import com.movie.mynetmovie.model.entity.Movie;

public interface MovieService {
    
    Movie createMovie(Movie movie);

    Movie getMovieById(UUID id);
}
