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

@Data
@Entity
public class Award {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Award name is required")
    private String awardName;

    @NotBlank(message = "Category is required")
    @Size(max = 50)
    private String category;

    @Size(max = 100)
    private String organization;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @NotNull(message = "Date received is required")
    private LocalDate dateReceived;

    @ManyToMany(mappedBy = "awards")
    private List<Actor> actors;
}
