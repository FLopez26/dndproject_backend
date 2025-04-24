package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Abilities;
import com.fls.DnDCharacterTool_Backend.repository.AbilitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbilitiesService {

    private final AbilitiesRepository abilitiesRepository;

    public AbilitiesService(AbilitiesRepository abilitiesRepository) {
        this.abilitiesRepository = abilitiesRepository;
    }

    public List<Abilities> getAllAbilities() {
        return abilitiesRepository.findAll();
    }

    public Optional<Abilities> getAbilitiesById(Integer id) {
        return abilitiesRepository.findById(id);
    }

    public Abilities createAbilities(Abilities abilities) {
        return abilitiesRepository.save(abilities);
    }

    public Abilities updateAbilities(Integer id, Abilities updatedAbilities) {
        return abilitiesRepository.findById(id)
                .map(abilities -> {
                    updatedAbilities.setAbilityId(id);
                    return abilitiesRepository.save(updatedAbilities);
                })
                .orElse(null);
    }

    public void deleteAbilities(Integer id) {
        abilitiesRepository.deleteById(id);
    }
}
