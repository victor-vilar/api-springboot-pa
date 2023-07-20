package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.equipment.EquipmentCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.equipment.EquipmentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipment;
import com.victorvilar.projetoempresa.mappers.EquipmentMapper;
import com.victorvilar.projetoempresa.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final EquipmentMapper mapper;

    @Autowired
    public EquipmentController(EquipmentService equipmentService, EquipmentMapper mapper){
        this.equipmentService = equipmentService;
        this.mapper = mapper;
    }

    /**
     * get all equipments
     * @return a list of equiapments
     */
    @GetMapping("")
    public ResponseEntity<List<EquipmentResponseDto>> getAllEquipments(){
        return ResponseEntity.ok(this.equipmentService.getAllEquipments());
    }

    /**
     * get equipmant by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResponseDto> getEquipmentById(@PathVariable Long id){
        return ResponseEntity.ok(this.equipmentService.getEquipmentById(id));
    }

    /**
     * save a new equipament
     * @param equipmentCreateDto equipamentCreateDto to save
     */
    @PostMapping("")
    public ResponseEntity<EquipmentResponseDto> saveEquipment(@Valid @RequestBody EquipmentCreateDto equipmentCreateDto){
        return ResponseEntity.ok(this.equipmentService.saveEquipment(equipmentCreateDto));
    }

    /**
     * update a equipament
     * @param equipmentCreateDto equipament instance to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@Valid @RequestBody EquipmentCreateDto equipmentCreateDto, @PathVariable Long id){
        Equipment equipment = this.mapper.toEquipament(equipmentCreateDto);
        return new ResponseEntity<Equipment>(this.equipmentService.updateEquipment(equipment,id),HttpStatus.OK);
    }

    /**
     * delete a equipament
     * @param id id to update
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable Long id){
        this.equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
