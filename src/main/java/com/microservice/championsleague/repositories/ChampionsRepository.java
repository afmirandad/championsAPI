package com.microservice.championsleague.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.championsleague.entities.ChampionsEntity;

@Repository
public interface ChampionsRepository extends JpaRepository<ChampionsEntity, UUID> {

}
