package com.fls.DnDCharacterTool_Backend.repository;

import com.fls.DnDCharacterTool_Backend.model.Competencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciesRepository extends JpaRepository<Competencies, Integer> {
}
