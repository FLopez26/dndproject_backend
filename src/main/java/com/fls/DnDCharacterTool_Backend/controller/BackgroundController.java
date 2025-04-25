package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Background;
import com.fls.DnDCharacterTool_Backend.service.BackgroundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/backgrounds")
public class BackgroundController {

    private final BackgroundService backgroundService;

    public BackgroundController(BackgroundService backgroundService) {
        this.backgroundService = backgroundService;
    }

    @GetMapping
    public ResponseEntity<List<Background>> getAllBackgrounds() {
        List<Background> backgrounds = backgroundService.getAllBackground();
        return new ResponseEntity<>(backgrounds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Background> getBackgroundById(@PathVariable Integer id) {
        Optional<Background> background = backgroundService.getBackgroundById(id);
        return background.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Background> createBackground(@RequestBody Background background) {
        Background createdBackground = backgroundService.createBackground(background);
        return new ResponseEntity<>(createdBackground, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Background> updateBackground(@PathVariable Integer id, @RequestBody Background updatedBackground) {
        Background updatedBackgroundResult = backgroundService.updateBackground(id, updatedBackground);
        return updatedBackgroundResult != null ? new ResponseEntity<>(updatedBackgroundResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBackground(@PathVariable Integer id) {
        backgroundService.deleteBackground(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
