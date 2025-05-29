package com.fls.DnDCharacterTool_Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer competencyId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "classId")
    private CharacterClass characterClass;

    @ManyToOne
    @JoinColumn(name = "backgroundId", referencedColumnName = "backgroundId")
    private Background background;

    public Integer getCompetencyId() {
        return competencyId;
    }

    public void setCompetencyId(Integer competencyId) {
        this.competencyId = competencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }
}
