package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Background;
import com.fls.DnDCharacterTool_Backend.repository.BackgroundRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackgroundService {

    private final BackgroundRepository backgroundRepository;

    public BackgroundService(BackgroundRepository backgroundRepository) {
        this.backgroundRepository = backgroundRepository;
    }

    public List<Background> getAllBackground() {
        return backgroundRepository.findAll();
    }

    public Optional<Background> getBackgroundById(Integer id) {
        return backgroundRepository.findById(id);
    }

    public Background createBackground(Background background) {
        return backgroundRepository.save(background);
    }

    public Background updateBackground(Integer id, Background updatedBackground) {
        return backgroundRepository.findById(id)
                .map(background -> {
                    updatedBackground.setBackgroundId(id);
                    return backgroundRepository.save(updatedBackground);
                })
                .orElse(null);
    }

    public void deleteBackground(Integer id) {
        backgroundRepository.deleteById(id);
    }
}
