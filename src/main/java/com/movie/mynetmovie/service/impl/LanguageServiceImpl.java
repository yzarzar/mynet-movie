package com.movie.mynetmovie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.mynetmovie.model.entity.Language;
import com.movie.mynetmovie.repository.LanguageRepository;
import com.movie.mynetmovie.service.LanguageService;

import lombok.NonNull;

@Service
public class LanguageServiceImpl implements LanguageService{
    
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language createLanguage(@NonNull Language language) {
        Language saveLanguage = languageRepository.save(language);
        return saveLanguage;
    }

    @Override
    public Language getLanguageById(int id) {
        Optional<Language> languageOptional = languageRepository.findById(id);
        return languageOptional.orElse(null);
    }
}
