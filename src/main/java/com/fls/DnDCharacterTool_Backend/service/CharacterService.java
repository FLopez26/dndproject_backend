package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Characters;
import com.fls.DnDCharacterTool_Backend.repository.CharacterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Characters> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Optional<Characters> getCharacterById(Integer id) {
        return characterRepository.findById(id);
    }

    @Transactional
    public Characters createCharacter(Characters character) {
        return characterRepository.save(character);
    }

    public Characters updateCharacter(Integer id, Characters updatedCharacter) {
        return characterRepository.findById(id)
                .map(character -> {
                    updatedCharacter.setCharacterId(id);
                    return characterRepository.save(updatedCharacter);
                })
                .orElse(null);
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }
}
