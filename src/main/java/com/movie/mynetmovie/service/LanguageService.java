package com.movie.mynetmovie.service;

import com.movie.mynetmovie.model.entity.Language;

public interface LanguageService {
    
    Language createLanguage(Language language);

    Language getLanguageById(int id);
}
