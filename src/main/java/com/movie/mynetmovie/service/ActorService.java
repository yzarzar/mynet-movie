package com.movie.mynetmovie.service;

import com.movie.mynetmovie.model.entity.Actor;

public interface ActorService {
    
    Actor createActor(Actor actor);

    Actor getActorById(int id);
}
