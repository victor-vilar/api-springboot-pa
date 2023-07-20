package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.residuetype.ResidueResponseDto;
import com.victorvilar.projetoempresa.domain.Residue;
import com.victorvilar.projetoempresa.exceptions.ResidueNotFoundException;
import com.victorvilar.projetoempresa.mappers.ResidueTypeMapper;
import com.victorvilar.projetoempresa.repository.ResidueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ResidueService {

    private final ResidueRepository residueRepository;
    private final ResidueTypeMapper mapper;

    @Autowired
    public ResidueService(
            ResidueRepository residueRepository,
            ResidueTypeMapper mapper){
        this.residueRepository = residueRepository;
        this.mapper = mapper;
    }

    /**
     * get all residues
     * @return a list of ResidueResponseDto
     */
    public List<ResidueResponseDto> getAll() {
        return this.mapper.toResidueTypeResponseDtoList(this.residueRepository.findAll());
    }

    /**
     * get Residue from repository and return as
     * ResidueResponseDto
     * @return ResidueResponseDto
     */
    public ResidueResponseDto getResidueById(Long id){
        return this.mapper.toResidueTypeResponseDto(
                this.residueRepository.findById(id)
                        .orElseThrow(() -> new ResidueNotFoundException("Residue Not Found !"))
        );
    }

    /**
     * get Residue from repository
     * @return Residue
     */
    public Residue findResidueById(Long id){
        return this.residueRepository
                .findById(id)
                .orElseThrow(() -> new ResidueNotFoundException("Residue Not Found !"));
    }

    @Transactional
    public void deleteByid(Long id){
        Residue residue = this.findById(id);
        this.residueRepository.delete(residue);
    }

    @Transactional
    public void addNewResidueType(Residue residue){
        this.residueRepository.save(residue);
    }

    @Transactional
    public Residue updateResidue(Residue residueType, Long id){
        Residue residue = this.findById(id);
        residue.setType(residueType.getType());
        residue.setDescription(residueType.getDescription());
        return residue;

    }


}
