package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.ResidueType;
import com.victorvilar.projetoempresa.exceptions.ResidueNotFoundException;
import com.victorvilar.projetoempresa.repository.ResidueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ResidueService {

    private final ResidueTypeRepository residueTypeRepository;

    @Autowired
    public ResidueService(ResidueTypeRepository residueTypeRepository){
        this.residueTypeRepository = residueTypeRepository;
    }

    public ResidueType findById(Long id){
        return this.residueTypeRepository.findById(id).orElseThrow(() -> new ResidueNotFoundException("This residue doesn't exist"));
    }

    @Transactional
    public void deleteByid(Long id){
        ResidueType residueType = this.findById(id);
        this.residueTypeRepository.delete(residueType);
    }

    @Transactional
    public void addNewResidueType(ResidueType residueType){
        this.residueTypeRepository.save(residueType);
    }

    @Transactional
    public ResidueType updateResidue(ResidueType residueType, Long id){
        ResidueType residue = this.findById(id);
        residue.setType(residueType.getType());
        residue.setDescription(residueType.getDescription());
        return residue;

    }


}
