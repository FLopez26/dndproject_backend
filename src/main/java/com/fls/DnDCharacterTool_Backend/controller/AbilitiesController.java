package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Abilities;
import com.fls.DnDCharacterTool_Backend.service.AbilitiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

    private final AbilitiesService abilitiesService;

    public AbilitiesController(AbilitiesService abilitiesService) {
        this.abilitiesService = abilitiesService;
    }

    @GetMapping
    public ResponseEntity<List<Abilities>> getAllAbilities() {
        List<Abilities> abilities = abilitiesService.getAllAbilities();
        return new ResponseEntity<>(abilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abilities> getAbilityById(@PathVariable Integer id) {
        Optional<Abilities> ability = abilitiesService.getAbilitiesById(id);
        return ability.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Abilities> createAbility(@RequestBody Abilities ability) {
        Abilities createdAbility = abilitiesService.createAbilities(ability);
        return new ResponseEntity<>(createdAbility, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abilities> updateAbility(@PathVariable Integer id, @RequestBody Abilities updatedAbility) {
        Abilities updatedAbilityResult = abilitiesService.updateAbilities(id, updatedAbility);
        return updatedAbilityResult != null ? new ResponseEntity<>(updatedAbilityResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbility(@PathVariable Integer id) {
        abilitiesService.deleteAbilities(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
