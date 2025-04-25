package com.fls.DnDCharacterTool_Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer characterId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    @ManyToOne
    @JoinColumn(name= "statsId", referencedColumnName = "statsId")
    private Stats stats;

    @ManyToOne
    @JoinColumn(name = "raceId", referencedColumnName = "raceId")
    private Race characterRace;

    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "classId")
    private CharacterClass characterClass;

    @ManyToOne
    @JoinColumn(name = "backgroundId", referencedColumnName = "backgroundId")
    private Background background;

    @ManyToOne
    @JoinColumn(name = "abilitiesId", referencedColumnName = "abilityId")
    private Abilities abilities;

    @ManyToOne
    @JoinColumn(name = "equipmentId", referencedColumnName = "equipmentId")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "competenciesId", referencedColumnName = "competencyId")
    private Competencies competencies;

    private byte[] image;

    private Boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
