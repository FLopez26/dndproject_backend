package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Stats;
import com.fls.DnDCharacterTool_Backend.repository.StatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatsService {

    private final StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

    public Optional<Stats> getStatsById(Integer id) {
        return statsRepository.findById(id);
    }

    public Stats createStats(Stats stats) {
        return statsRepository.save(stats);
    }

    public Stats updateStats(Integer id, Stats updatedStats) {
        return statsRepository.findById(id)
                .map(stats -> {
                    updatedStats.setStatsId(id);
                    return statsRepository.save(updatedStats);
                })
                .orElse(null);
    }

    public void deleteStats(Integer id) {
        statsRepository.deleteById(id);
    }
}
