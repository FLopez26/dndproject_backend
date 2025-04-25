package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.StatsChange;
import com.fls.DnDCharacterTool_Backend.service.StatsChangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stats-changes")
public class StatsChangeController {

    private final StatsChangeService statsChangeService;

    public StatsChangeController(StatsChangeService statsChangeService) {
        this.statsChangeService = statsChangeService;
    }

    @GetMapping
    public ResponseEntity<List<StatsChange>> getAllStatsChanges() {
        List<StatsChange> statsChanges = statsChangeService.getAllStatsChange();
        return new ResponseEntity<>(statsChanges, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatsChange> getStatsChangeById(@PathVariable Integer id) {
        Optional<StatsChange> statsChange = statsChangeService.getStatsChangeById(id);
        return statsChange.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<StatsChange> createStatsChange(@RequestBody StatsChange statsChange) {
        StatsChange createdStatsChange = statsChangeService.createStatsChange(statsChange);
        return new ResponseEntity<>(createdStatsChange, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatsChange> updateStatsChange(@PathVariable Integer id, @RequestBody StatsChange updatedStatsChange) {
        StatsChange updatedStatsChangeResult = statsChangeService.updateStatsChange(id, updatedStatsChange);
        return updatedStatsChangeResult != null ? new ResponseEntity<>(updatedStatsChangeResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatsChange(@PathVariable Integer id) {
        statsChangeService.deleteStatsChange(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
