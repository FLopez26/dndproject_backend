package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.CharacterClass;
import com.fls.DnDCharacterTool_Backend.repository.CharacterClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterClassService {

    private final CharacterClassRepository classRepository;

    public CharacterClassService(CharacterClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<CharacterClass> getAllClass() {
        return classRepository.findAll();
    }

    public Optional<CharacterClass> getClassById(Integer id) {
        return classRepository.findById(id);
    }

    public CharacterClass createClass(CharacterClass chaClass) {
        return classRepository.save(chaClass);
    }

    public CharacterClass updateClass(Integer id, CharacterClass updatedClass) {
        return classRepository.findById(id)
                .map(characterClass -> {
                    updatedClass.setClassId(id);
                    return classRepository.save(updatedClass);
                })
                .orElse(null);
    }

    public void deleteClass(Integer id) {
        classRepository.deleteById(id);
    }
}

