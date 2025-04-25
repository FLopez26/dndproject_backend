package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Race;
import com.fls.DnDCharacterTool_Backend.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRace() {
        return raceRepository.findAll();
    }

    public Optional<Race> getRaceById(Integer id) {
        return raceRepository.findById(id);
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    public Race updateRace(Integer id, Race updatedRace) {
        return raceRepository.findById(id)
                .map(race -> {
                    updatedRace.setRaceId(id);
                    return raceRepository.save(updatedRace);
                })
                .orElse(null);
    }

    public void deleteRace(Integer id) {
        raceRepository.deleteById(id);
    }
}
