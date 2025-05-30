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

    @ManyToOne(cascade = CascadeType.ALL)
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abilitiesId", referencedColumnName = "abilityId")
    private Abilities abilities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipmentId", referencedColumnName = "equipmentId")
    private Equipment equipment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "competenciesId", referencedColumnName = "competencyId")
    private Competencies competencies;

    private byte[] image;

    private Boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
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

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Competencies getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Competencies competencies) {
        this.competencies = competencies;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
