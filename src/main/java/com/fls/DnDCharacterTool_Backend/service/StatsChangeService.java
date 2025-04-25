package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.StatsChange;
import com.fls.DnDCharacterTool_Backend.repository.StatsChangeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatsChangeService {

    private final StatsChangeRepository statsChangeRepository;

    public StatsChangeService(StatsChangeRepository statsChangeRepository) {
        this.statsChangeRepository = statsChangeRepository;
    }

    public List<StatsChange> getAllStatsChange() {
        return statsChangeRepository.findAll();
    }

    public Optional<StatsChange> getStatsChangeById(Integer id) {
        return statsChangeRepository.findById(id);
    }

    public StatsChange createStatsChange(StatsChange statsChange) {
        return statsChangeRepository.save(statsChange);
    }

    public StatsChange updateStatsChange(Integer id, StatsChange updatedStatsChange) {
        return statsChangeRepository.findById(id)
                .map(statsChange -> {
                    updatedStatsChange.setStatsChangeId(id);
                    return statsChangeRepository.save(updatedStatsChange);
                })
                .orElse(null);
    }

    public void deleteStatsChange(Integer id) {
        statsChangeRepository.deleteById(id);
    }
}
