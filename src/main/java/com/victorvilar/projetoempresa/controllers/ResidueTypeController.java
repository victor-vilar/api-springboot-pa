package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.domain.ResidueType;
import com.victorvilar.projetoempresa.exceptions.ResidueNotFoundException;
import com.victorvilar.projetoempresa.repository.ResidueTypeRepository;
import com.victorvilar.projetoempresa.services.ResidueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residues")
public class ResidueTypeController {

    private final ResidueService residueService;

    @Autowired
    public ResidueTypeController(ResidueService residueService){
        this.residueService = residueService;
    }

    /**
     * find residue by id
     * @param id id of a residue
     * @return residue
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResidueType> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.residueService.findById(id), HttpStatus.FOUND);
    }

    /**
     * delete a residue by id
     * @param id if of a residue
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable Long id){
        this.residueService.deleteByid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * add a new residue type
     * @param residueType
     */
    @PostMapping("/")
    public ResponseEntity<?> addNewResidueType(@RequestBody ResidueType residueType){
        this.residueService.addNewResidueType(residueType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * update a residue
     * @param id id of a residue
     * @param residue residue type with data
     * @return residue updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResidueType> updateResidue(@PathVariable Long id, @RequestBody ResidueType residue){
        return new ResponseEntity<>(this.residueService.updateResidue(residue, id),HttpStatus.OK);
    }


}
