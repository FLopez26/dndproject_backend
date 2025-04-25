package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Competencies;
import com.fls.DnDCharacterTool_Backend.repository.CompetenciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenciesService {

    private final CompetenciesRepository competenciesRepository;

    public CompetenciesService(CompetenciesRepository competenciesRepository) {
        this.competenciesRepository = competenciesRepository;
    }

    public List<Competencies> getAllCompetencies() {
        return competenciesRepository.findAll();
    }

    public Optional<Competencies> getCompetenciesById(Integer id) {
        return competenciesRepository.findById(id);
    }

    public Competencies createCompetencies(Competencies competencies) {
        return competenciesRepository.save(competencies);
    }

    public Competencies updateCompetencies(Integer id, Competencies updatedCompetencies) {
        return competenciesRepository.findById(id)
                .map(competencies -> {
                    updatedCompetencies.setCompetencyId(id);
                    return competenciesRepository.save(updatedCompetencies);
                })
                .orElse(null);
    }

    public void deleteCompetencies(Integer id) {
        competenciesRepository.deleteById(id);
    }
}
