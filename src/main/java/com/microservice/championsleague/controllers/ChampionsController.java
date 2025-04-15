package com.microservice.championsleague.controllers;
import com.microservice.championsleague.services.ChampionsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/champions")
public class ChampionsController {

    private final ChampionsService championsService;

    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
    }
    
    @GetMapping()
    public String getChampionsItem() {
        return championsService.getAllChampions();
    }

    @PostMapping()
    public String createChampionsItem() {
        return "Created";
    }

    @PutMapping()
    public String updateChampionsItem() {
        return "Updated";
    }
    
    @DeleteMapping()
    public String deleteChampionsItem(){
        return "Deleted";
    }
    
}
