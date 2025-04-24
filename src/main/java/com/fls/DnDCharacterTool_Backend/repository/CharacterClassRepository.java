package com.fls.DnDCharacterTool_Backend.repository;

import com.fls.DnDCharacterTool_Backend.model.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Integer> {
}
