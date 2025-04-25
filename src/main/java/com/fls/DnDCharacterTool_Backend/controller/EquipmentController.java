package com.fls.DnDCharacterTool_Backend.controller;

import com.fls.DnDCharacterTool_Backend.model.Equipment;
import com.fls.DnDCharacterTool_Backend.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipment = equipmentService.getAllEquipment();
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Integer id) {
        Optional<Equipment> equipment = equipmentService.getEquipmentById(id);
        return equipment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
        Equipment createdEquipment = equipmentService.createEquipment(equipment);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Integer id, @RequestBody Equipment updatedEquipment) {
        Equipment updatedEquipmentResult = equipmentService.updateEquipment(id, updatedEquipment);
        return updatedEquipmentResult != null ? new ResponseEntity<>(updatedEquipmentResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
