package com.movie.mynetmovie.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.mynetmovie.model.entity.Language;
import com.movie.mynetmovie.model.entity.Movie;
import com.movie.mynetmovie.service.LanguageService;
import com.movie.mynetmovie.service.MovieService;
import com.movie.mynetmovie.utils.io.ApiResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/language")
public class LanguageController {
    
    @Autowired
    private LanguageService languageService;

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ApiResponse<Language> postLanguage(@RequestBody Language language) {
        Language saveLanguage = languageService.createLanguage(language);
        return ApiResponse.success(saveLanguage);
    }
    
    @PutMapping("/{languageId}/movie/{movieId}")
    public ApiResponse<String> associateActorWithAward(
        @PathVariable("languageId") int languageId, 
        @PathVariable("movieId") UUID movieId) {
        try {
            Language language = languageService.getLanguageById(languageId);
            Movie movie = movieService.getMovieById(movieId);

            if (language != null && movie != null) {
                language.getMovies().add(movie);
                languageService.createLanguage(language); 
                return ApiResponse.success("Actor associated with the movie successfully.");
            } else {
                return ApiResponse.error(ApiResponse.Status.NOT_FOUND, "Movie or Actor not found.");
            }
        } catch (Exception e) {
            return ApiResponse.error(ApiResponse.Status.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
