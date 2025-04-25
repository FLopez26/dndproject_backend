package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.CharacterClass;
import com.fls.DnDCharacterTool_Backend.service.CharacterClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/character-classes")
public class CharacterClassController {

    private final CharacterClassService characterClassService;

    public CharacterClassController(CharacterClassService characterClassService) {
        this.characterClassService = characterClassService;
    }

    @GetMapping
    public ResponseEntity<List<CharacterClass>> getAllCharacterClasses() {
        List<CharacterClass> characterClasses = characterClassService.getAllClass();
        return new ResponseEntity<>(characterClasses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterClass> getCharacterClassById(@PathVariable Integer id) {
        Optional<CharacterClass> characterClass = characterClassService.getClassById(id);
        return characterClass.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CharacterClass> createCharacterClass(@RequestBody CharacterClass characterClass) {
        CharacterClass createdCharacterClass = characterClassService.createClass(characterClass);
        return new ResponseEntity<>(createdCharacterClass, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterClass> updateCharacterClass(@PathVariable Integer id, @RequestBody CharacterClass updatedCharacterClass) {
        CharacterClass updatedCharacterClassResult = characterClassService.updateClass(id, updatedCharacterClass);
        return updatedCharacterClassResult != null ? new ResponseEntity<>(updatedCharacterClassResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterClass(@PathVariable Integer id) {
        characterClassService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
