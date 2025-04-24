package com.fls.DnDCharacterTool_Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer competencyId;

    private String name;

    private Integer classId; // Referencia al ID de Class
    private Integer backgroundId; // Referencia al ID de Background
}
