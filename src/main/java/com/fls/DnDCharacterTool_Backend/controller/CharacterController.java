package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Characters;
import com.fls.DnDCharacterTool_Backend.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<List<Characters>> getAllCharacters() {
        List<Characters> characters = characterService.getAllCharacters();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Characters> getCharacterById(@PathVariable Integer id) {
        Optional<Characters> character = characterService.getCharacterById(id);
        return character.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Characters> createCharacter(@RequestBody Characters character) {
        Characters createdCharacter = characterService.createCharacter(character);
        return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Characters> updateCharacter(@PathVariable Integer id, @RequestBody Characters updatedCharacter) {
        Characters updated = characterService.updateCharacter(id, updatedCharacter);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
