package com.fls.DnDCharacterTool_Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statsId;

    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Integer hitPoints;

    @ManyToOne
    @JoinColumn(name = "statsChangeId", referencedColumnName = "statsChangeId")
    private StatsChange statsChange;
}
