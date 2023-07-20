package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.residuetype.ResidueCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.residuetype.ResidueResponseDto;
import com.victorvilar.projetoempresa.domain.Residue;
import com.victorvilar.projetoempresa.mappers.ResidueTypeMapper;
import com.victorvilar.projetoempresa.services.ResidueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residue")
public class ResidueController {

    private final ResidueService residueService;
    private final ResidueTypeMapper mapper;

    @Autowired
    public ResidueController(ResidueService residueService, ResidueTypeMapper mapper){
        this.residueService = residueService;
        this.mapper = mapper;
    }

    /**
     * get all residues
     * @return a list of ResidueResponseDto
     */
    @GetMapping("")
    public ResponseEntity<List<ResidueResponseDto>> getAll(){
        return ResponseEntity.ok(this.residueService.getAll());
    }

    /**
     * find residue by id
     * @param id id of a residue
     * @return residue
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResidueResponseDto> getResidueById(@PathVariable Long id){
        return ResponseEntity.ok(this.residueService.getResidueById(id));
    }

    /**
     * add a new residue type
     * @param residue
     */
    @PostMapping("")
    public ResponseEntity<ResidueResponseDto> save(@RequestBody ResidueCreateDto residue){
        return ResponseEntity.ok(this.residueService.save(residue));

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
     * update a residue
     * @param id id of a residue
     * @param residue residue type with data
     * @return residue updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<Residue> updateResidue(@PathVariable Long id, @RequestBody Residue residue){
        return new ResponseEntity<>(this.residueService.updateResidue(residue, id),HttpStatus.OK);
    }


}
