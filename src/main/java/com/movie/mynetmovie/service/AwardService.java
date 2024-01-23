package com.movie.mynetmovie.service;

import com.movie.mynetmovie.model.entity.Award;

/**
 * AwardService
 */
public interface AwardService {

    Award createAward(Award award);
    Award getAwardById(int id);
}