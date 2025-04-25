package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Stats;
import com.fls.DnDCharacterTool_Backend.service.StatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<List<Stats>> getAllStats() {
        List<Stats> allStats = statsService.getAllStats();
        return new ResponseEntity<>(allStats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stats> getStatsById(@PathVariable Integer id) {
        Optional<Stats> stats = statsService.getStatsById(id);
        return stats.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Stats> createStats(@RequestBody Stats stats) {
        Stats createdStats = statsService.createStats(stats);
        return new ResponseEntity<>(createdStats, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stats> updateStats(@PathVariable Integer id, @RequestBody Stats updatedStats) {
        Stats updatedStatsResult = statsService.updateStats(id, updatedStats);
        return updatedStatsResult != null ? new ResponseEntity<>(updatedStatsResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStats(@PathVariable Integer id) {
        statsService.deleteStats(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
