package com.movie.mynetmovie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mynetmovie.model.entity.Award;
import com.movie.mynetmovie.model.repository.AwardRepository;
import com.movie.mynetmovie.service.AwardService;

import lombok.NonNull;

@Service
public class AwardServiceImpl implements AwardService{

    @Autowired
    private AwardRepository awardRepository;

    @Override
    public Award createAward(@NonNull Award award) {
        Award saveAward = awardRepository.save(award);
        return saveAward;
    }

    @Override
    public Award getAwardById(int id) {
        Optional<Award> awardOptional = awardRepository.findById(id);
        return awardOptional.orElse(null);
    }
    
}
