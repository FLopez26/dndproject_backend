package com.fls.DnDCharacterTool_Backend.repository;

import com.fls.DnDCharacterTool_Backend.model.Abilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitiesRepository extends JpaRepository<Abilities, Integer> {
}
