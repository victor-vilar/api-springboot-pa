package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Residue;
import com.victorvilar.projetoempresa.exceptions.ResidueNotFoundException;
import com.victorvilar.projetoempresa.repository.ResidueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ResidueService {

    private final ResidueTypeRepository residueTypeRepository;

    @Autowired
    public ResidueService(ResidueTypeRepository residueTypeRepository){
        this.residueTypeRepository = residueTypeRepository;
    }

    public Residue findById(Long id){
        return this.residueTypeRepository.findById(id).orElseThrow(() -> new ResidueNotFoundException("This residue doesn't exist"));
    }

    @Transactional
    public void deleteByid(Long id){
        Residue residue = this.findById(id);
        this.residueTypeRepository.delete(residue);
    }

    @Transactional
    public void addNewResidueType(Residue residue){
        this.residueTypeRepository.save(residue);
    }

    @Transactional
    public Residue updateResidue(Residue residueType, Long id){
        Residue residue = this.findById(id);
        residue.setType(residueType.getType());
        residue.setDescription(residueType.getDescription());
        return residue;

    }

    public List<Residue> getAll() {
        return this.residueTypeRepository.findAll();
    }
}
