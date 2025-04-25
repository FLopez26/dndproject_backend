package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.Equipment;
import com.fls.DnDCharacterTool_Backend.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentById(Integer id) {
        return equipmentRepository.findById(id);
    }

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Integer id, Equipment updatedEquipment) {
        return equipmentRepository.findById(id)
                .map(equipment -> {
                    updatedEquipment.setEquipmentId(id);
                    return equipmentRepository.save(updatedEquipment);
                })
                .orElse(null);
    }

    public void deleteEquipment(Integer id) {
        equipmentRepository.deleteById(id);
    }
}
