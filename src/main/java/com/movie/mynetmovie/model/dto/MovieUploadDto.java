package com.movie.mynetmovie.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieUploadDto {
    
    private String title;
    private String plot;
    private MultipartFile file;
}
