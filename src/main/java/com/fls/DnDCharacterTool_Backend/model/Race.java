package com.fls.DnDCharacterTool_Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Race {

    @Id
    private Integer raceId;

    private String name;
    private Integer raceSelection;

    @Column(columnDefinition = "TEXT")
    private String abilities;

    @Column(columnDefinition = "TEXT")
    private String competencies;

    @ManyToOne
    @JoinColumn(name = "statsChangeId", referencedColumnName = "statsChangeId")
    private StatsChange statsChange;
}
