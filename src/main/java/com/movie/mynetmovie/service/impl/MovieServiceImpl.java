package com.movie.mynetmovie.service.impl;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movie.mynetmovie.model.dto.MovieUploadDto;
import com.movie.mynetmovie.model.entity.Movie;
import com.movie.mynetmovie.model.repository.MovieRepository;
import com.movie.mynetmovie.service.MovieService;

import jakarta.transaction.Transactional;
import lombok.NonNull;

@Service
public class MovieServiceImpl implements MovieService {

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

    @Override
    @Transactional
    public void uploadMovie(MovieUploadDto movieUploadDto) {
        try {
            String title = movieUploadDto.getTitle();
            String plot = movieUploadDto.getPlot();

            MultipartFile file = movieUploadDto.getFile();

            String storageLocation = "/Users/yarzar/Desktop/mynet-movie/uploads";
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(storageLocation + File.separator + fileName));

            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setPlot(plot);
            movie.setFileName(fileName);

            movieRepository.save(movie);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload movie: " + e.getMessage(), e);
        }
    }
}
