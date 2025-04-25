package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Competencies;
import com.fls.DnDCharacterTool_Backend.service.CompetenciesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competencies")
public class CompetenciesController {

    private final CompetenciesService competenciesService;

    public CompetenciesController(CompetenciesService competenciesService) {
        this.competenciesService = competenciesService;
    }

    @GetMapping
    public ResponseEntity<List<Competencies>> getAllCompetencies() {
        List<Competencies> competencies = competenciesService.getAllCompetencies();
        return new ResponseEntity<>(competencies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencies> getCompetenciesById(@PathVariable Integer id) {
        Optional<Competencies> competency = competenciesService.getCompetenciesById(id);
        return competency.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Competencies> createCompetencies(@RequestBody Competencies competency) {
        Competencies createdCompetency = competenciesService.createCompetencies(competency);
        return new ResponseEntity<>(createdCompetency, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencies> updateCompetencies(@PathVariable Integer id, @RequestBody Competencies updatedCompetency) {
        Competencies updatedCompetencyResult = competenciesService.updateCompetencies(id, updatedCompetency);
        return updatedCompetencyResult != null ? new ResponseEntity<>(updatedCompetencyResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetencies(@PathVariable Integer id) {
        competenciesService.deleteCompetencies(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
