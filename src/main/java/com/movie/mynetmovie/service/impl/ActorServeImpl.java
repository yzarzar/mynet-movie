package com.movie.mynetmovie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mynetmovie.model.entity.Actor;
import com.movie.mynetmovie.model.repository.ActorRepository;
import com.movie.mynetmovie.service.ActorService;

import lombok.NonNull;

@Service
public class ActorServeImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor createActor(@NonNull Actor actor) {
        Actor saveActor = actorRepository.save(actor);
        return saveActor;
    }

    @Override
    public Actor getActorById(int id) {
        Optional<Actor> actorsOptional = actorRepository.findById(id);
        return actorsOptional.orElse(null);
    }
    
}
