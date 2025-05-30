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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer raceId;

    private String name;
    private Integer raceSelection;
    private Integer speed;

    @Column(columnDefinition = "TEXT")
    private String abilities;

    @Column(columnDefinition = "TEXT")
    private String competencies;

    @ManyToOne
    @JoinColumn(name = "statsChangeId", referencedColumnName = "statsChangeId")
    private StatsChange statsChange;

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }

    public Integer getRaceSelection() {
        return raceSelection;
    }

    public void setRaceSelection(Integer raceSelection) {
        this.raceSelection = raceSelection;
    }

    public StatsChange getStatsChange() {
        return statsChange;
    }

    public void setStatsChange(StatsChange statsChange) {
        this.statsChange = statsChange;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
