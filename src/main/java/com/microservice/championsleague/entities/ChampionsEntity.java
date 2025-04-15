package com.microservice.championsleague.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.util.UUID;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "CHAMPIONS")
public class ChampionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAMECHAMPION")
    private String nameChampion;

    @Column(name = "COUNTRYCHAMPION")
    private String countryChampion;

    @Column(name = "YEARCHAMPIONSHIP")
    private String yearChampionship;

}
