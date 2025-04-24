package com.fls.DnDCharacterTool_Backend.repository;

import com.fls.DnDCharacterTool_Backend.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
}
