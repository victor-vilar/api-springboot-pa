package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.services.EquipamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipament")
public class EquipamentController {

    private final EquipamentService equipamentService;

    @Autowired
    public EquipamentController(EquipamentService equipamentService){
        this.equipamentService = equipamentService;
    }

    /**
     * get all equipments
     * @return a list of equiapments
     */
    public ResponseEntity<List<Equipament>> getAllEquipaments(){
        return new ResponseEntity<List<Equipament>>(this.equipamentService.getAllEquipaments(), HttpStatus.FOUND);

    }

    /**
     * get equipmant by id
     * @param id
     * @return
     */
    public ResponseEntity<Equipament> getEquipamentById(Long id){
        return new ResponseEntity<>(this.equipamentService.getEquipamentById(id),HttpStatus.FOUND);
    }

    /**
     * save a new equipament
     * @param equipament equipament to save
     */
    public ResponseEntity<?> saveEquipament(Equipament equipament){
        this.equipamentService.saveEquipament(equipament);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * update a equipament
     * @param equipament equipament instace to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    public ResponseEntity<Equipament> updateEquipament(Equipament equipament, Long id){
        return new ResponseEntity<Equipament>(this.equipamentService.updateEquipament(equipament,id),HttpStatus.OK);
    }

    /**
     * delete a equipament
     * @param id id to update
     */
    public ResponseEntity<?>deleteEquipament( Long id){
        this.equipamentService.deleteEquipament(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
