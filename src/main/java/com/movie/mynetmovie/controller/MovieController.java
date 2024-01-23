package com.movie.mynetmovie.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.mynetmovie.model.entity.Actor;
import com.movie.mynetmovie.model.entity.Movie;
import com.movie.mynetmovie.service.ActorService;
import com.movie.mynetmovie.service.MovieService;
import com.movie.mynetmovie.utils.io.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ApiResponse<Movie> postMovie(@RequestBody Movie movie) {
        Movie saveMovie = movieService.createMovie(movie);
        return ApiResponse.success(saveMovie);
    }

    @GetMapping("/{id}")
    public ApiResponse<Movie> getMovieById(@PathVariable String id) throws Exception {
        try {
            UUID uuid = UUID.fromString(id);
            Movie movie = movieService.getMovieById(uuid);
            if (movie != null) {
                return ApiResponse.success(movie);
            } else {
                throw new Exception("Movie not found with ID: " + id);
            }
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid UUID format: " + id);
        }
    }

    @PutMapping("/{movieId}/actor/{actorId}")
    public ApiResponse<String> associateActorWithMovie(
            @PathVariable("movieId") UUID movieId,
            @PathVariable("actorId") int actorId) {

        try {
            Movie movie = movieService.getMovieById(movieId);
            Actor actor = actorService.getActorById(actorId);

            if (movie != null && actor != null) {
                movie.getActors().add(actor);
                movieService.createMovie(movie); 
                return ApiResponse.success("Actor associated with the movie successfully.");
            } else {
                return ApiResponse.error(ApiResponse.Status.NOT_FOUND, "Movie or Actor not found.");
            }
        } catch (Exception e) {
            return ApiResponse.error(ApiResponse.Status.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
