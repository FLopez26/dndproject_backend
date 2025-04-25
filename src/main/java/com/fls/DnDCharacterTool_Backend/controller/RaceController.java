package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Race;
import com.fls.DnDCharacterTool_Backend.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public ResponseEntity<List<Race>> getAllRaces() {
        List<Race> races = raceService.getAllRace();
        return new ResponseEntity<>(races, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Integer id) {
        Optional<Race> race = raceService.getRaceById(id);
        return race.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        Race createdRace = raceService.createRace(race);
        return new ResponseEntity<>(createdRace, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Integer id, @RequestBody Race updatedRace) {
        Race updatedRaceResult = raceService.updateRace(id, updatedRace);
        return updatedRaceResult != null ? new ResponseEntity<>(updatedRaceResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Integer id) {
        raceService.deleteRace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
