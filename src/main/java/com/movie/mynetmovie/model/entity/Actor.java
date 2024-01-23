package com.movie.mynetmovie.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    private String lastName;

    @Column(nullable = true)
    private String photoPath;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @NotNull(message = "Nationality is required")
    private String nationality;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}
