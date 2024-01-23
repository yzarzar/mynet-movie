package com.movie.mynetmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.mynetmovie.model.entity.Actor;
import com.movie.mynetmovie.model.entity.Award;
import com.movie.mynetmovie.service.ActorService;
import com.movie.mynetmovie.service.AwardService;
import com.movie.mynetmovie.utils.io.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/actor")
public class ActorController {
    
    @Autowired
    private ActorService actorService;

    @Autowired
    private AwardService awardService;

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
    
    @PutMapping("/{actorId}/award/{awardId}")
    public ApiResponse<String> associateActorWithAward(
        @PathVariable("actorId") int actorId, 
        @PathVariable("awardId") int awardId) {
        try {
            Actor actor = actorService.getActorById(actorId);
            Award award = awardService.getAwardById(awardId);
            if (actor != null && award != null) {
                actor.getAwards().add(award);
                awardService.createAward(award); 
                return ApiResponse.success("Actor associated with the movie successfully.");
            } else {
                return ApiResponse.error(ApiResponse.Status.NOT_FOUND, "Movie or Actor not found.");
            }
        } catch (Exception e) {
            return ApiResponse.error(ApiResponse.Status.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
