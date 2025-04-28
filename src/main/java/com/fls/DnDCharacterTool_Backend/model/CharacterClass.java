package com.fls.DnDCharacterTool_Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterClass {

    @Id
    private Integer classId;

    private String name;
    private Integer classSelection;
    private String diceHitPoints;

    @Column(columnDefinition = "TEXT")
    private String equipment;

    @Column(columnDefinition = "TEXT")
    private String competencies;

    @Column(columnDefinition = "TEXT")
    private String abilities;
}
