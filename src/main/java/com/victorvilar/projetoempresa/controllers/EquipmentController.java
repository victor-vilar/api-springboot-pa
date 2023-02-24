package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.equipament.EquipmentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.mappers.EquipmentMapper;
import com.victorvilar.projetoempresa.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipament")
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
    public ResponseEntity<List<EquipmentResponseDto>> getAllEquipaments(){
        return new ResponseEntity<List<EquipmentResponseDto>>(
                this.mapper.toEquipamentResponseDtoList(
                this.equipmentService.getAllEquipaments()), HttpStatus.OK);
    }

    /**
     * get equipmant by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResponseDto> getEquipamentById(@PathVariable Long id){
        return new ResponseEntity<EquipmentResponseDto>(
                this.mapper.toEquipamentResponseDto(
                this.equipmentService.findEquipamentById(id)),HttpStatus.OK);
    }

    /**
     * save a new equipament
     * @param equipament equipament to save
     */
    @PostMapping("")
    public ResponseEntity<?> saveEquipament(@RequestBody Equipament equipament){
        System.out.println(equipament);
        this.equipmentService.saveEquipament(equipament);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * update a equipament
     * @param equipament equipament instace to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipament> updateEquipament(@RequestBody Equipament equipament,@PathVariable Long id){
        return new ResponseEntity<Equipament>(this.equipmentService.updateEquipament(equipament,id),HttpStatus.OK);
    }

    /**
     * delete a equipament
     * @param id id to update
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteEquipament(@PathVariable Long id){
        this.equipmentService.deleteEquipament(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
