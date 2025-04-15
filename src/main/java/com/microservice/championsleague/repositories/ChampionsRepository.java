package com.microservice.championsleague.repositories;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.championsleague.entities.ChampionsEntity;

@Repository
public interface ChampionsRepository extends JpaRepository<ChampionsEntity, UUID> {

    List<ChampionsEntity> findByNameChampion(String nameChampion);
    
    List<ChampionsEntity> findByCountryChampion(String countryChampion);
    
    List<ChampionsEntity> findByYearChampionship(String yearChampionship);
    
    List<ChampionsEntity> findByCountryChampionAndYearChampionship(String countryChampion, String yearChampionship);
    
    List<ChampionsEntity> findByNameChampionContainingIgnoreCase(String namePart);

    @Query("SELECT c FROM ChampionsEntity c WHERE c.countryChampion = :country AND c.yearChampionship = :year")
    List<ChampionsEntity> buscarPorPaisYAno(@Param("country") String country, @Param("year") String year);
}
