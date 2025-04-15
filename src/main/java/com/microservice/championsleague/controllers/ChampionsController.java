package com.microservice.championsleague.controllers;

import com.microservice.championsleague.entities.ChampionsEntity;
import com.microservice.championsleague.services.ChampionsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/champions")
public class ChampionsController {

    private final ChampionsService championsService;

    public ChampionsController(ChampionsService championsService) {
        this.championsService = championsService;
    }

    @GetMapping
    public ResponseEntity<List<ChampionsEntity>> getAllChampions() {
        return ResponseEntity.ok(championsService.getAllChampions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChampionsEntity> getChampionById(@PathVariable UUID id) {
        ChampionsEntity champion = championsService.getChampionById(id);
        return champion != null ? ResponseEntity.ok(champion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ChampionsEntity> createChampion(@RequestBody ChampionsEntity champion) {
        ChampionsEntity saved = championsService.saveChampion(champion);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChampionsEntity> updateChampion(@PathVariable UUID id, @RequestBody ChampionsEntity updatedData) {
        ChampionsEntity existing = championsService.getChampionById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updatedData.setId(id);
        ChampionsEntity updated = championsService.saveChampion(updatedData);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChampion(@PathVariable UUID id) {
        ChampionsEntity existing = championsService.getChampionById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        championsService.deleteChampion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<ChampionsEntity>> getByCountry(@PathVariable String country) {
        return ResponseEntity.ok(championsService.getChampionsByCountry(country));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<ChampionsEntity>> getByYear(@PathVariable String year) {
        return ResponseEntity.ok(championsService.getChampionsByYear(year));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ChampionsEntity>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(championsService.searchChampionByName(name));
    }
}
