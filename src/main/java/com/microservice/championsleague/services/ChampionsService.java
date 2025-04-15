package com.microservice.championsleague.services;

import org.springframework.stereotype.Service;
import com.microservice.championsleague.repositories.ChampionsRepository;

@Service
public class ChampionsService {

    private final ChampionsRepository championsRepository;

    public ChampionsService(ChampionsRepository championsRepository) {
        this.championsRepository = championsRepository;
    }

    public String getAllChampions() {
        return championsRepository.findAll().toString();
    }

    
}
