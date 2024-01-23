package com.movie.mynetmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.mynetmovie.model.entity.Award;
import com.movie.mynetmovie.service.AwardService;
import com.movie.mynetmovie.utils.io.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/award")
public class AwardController {
    
    @Autowired
    private AwardService awardService;

    @PostMapping
    public ApiResponse<Award> postAward(@RequestBody Award entity) {
        Award saveAward = awardService.createAward(entity);
        return ApiResponse.success(saveAward);
    }
    
    @GetMapping("{id}")
    public ApiResponse<Award> getAwardById(@PathVariable("id") int id){
        Award getAward = awardService.getAwardById(id);
        if (getAward != null) {
            return ApiResponse.success(getAward);
        } else {
            return ApiResponse.idNotFound(null);
        }
    }
    
}
