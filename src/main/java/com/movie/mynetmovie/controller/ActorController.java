package com.movie.mynetmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.mynetmovie.model.entity.Actor;
import com.movie.mynetmovie.service.ActorService;
import com.movie.mynetmovie.utils.io.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/actor")
public class ActorController {
    
    @Autowired
    private ActorService actorService;

    @PostMapping
    public ApiResponse<Actor> postActor(@RequestBody Actor actor) {
        Actor saveActor = actorService.createActor(actor);
        return ApiResponse.success(saveActor);
    }
    
    @GetMapping("{id}")
    public ApiResponse<Actor> getActorById(@PathVariable("id") int id) throws Exception{
        Actor actor = actorService.getActorById(id);
        if (actor != null) {
            return ApiResponse.success(actor);
        } else {
            throw new Exception("Author not found with ID : " + id);
        }
    }
    
}
