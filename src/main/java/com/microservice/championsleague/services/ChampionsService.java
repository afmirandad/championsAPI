package com.microservice.championsleague.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservice.championsleague.entities.ChampionsEntity;
import com.microservice.championsleague.repositories.ChampionsRepository;

@Service
public class ChampionsService {

    private final ChampionsRepository championsRepository;

    public ChampionsService(ChampionsRepository championsRepository) {
        this.championsRepository = championsRepository;
    }

    public List<ChampionsEntity> getAllChampions() {
        return championsRepository.findAll();
    }

    public ChampionsEntity getChampionById(UUID id) {
        return championsRepository.findById(id)
                .orElse(null);
    }

    public List<ChampionsEntity> getChampionsByCountry(String country) {
        return championsRepository.findByCountryChampion(country);
    }

    public List<ChampionsEntity> getChampionsByYear(String year) {
        return championsRepository.findByYearChampionship(year);
    }

    public List<ChampionsEntity> searchChampionByName(String name) {
        return championsRepository.findByNameChampionContainingIgnoreCase(name);
    }

    public ChampionsEntity saveChampion(ChampionsEntity champion) {
        return championsRepository.save(champion);
    }

    public void deleteChampion(UUID id) {
        championsRepository.deleteById(id);
    }
}