package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.controllers.dto.equipment.EquipmentCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.equipment.EquipmentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipment;
import com.victorvilar.projetoempresa.exceptions.EquipmentNotFoundException;
import com.victorvilar.projetoempresa.mappers.EquipmentMapper;
import com.victorvilar.projetoempresa.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Autowired
    public EquipmentService(
            EquipmentRepository equipmentRepository,
            EquipmentMapper equipmentMapper){
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    /**
     * get all equipments
     * @return a list of equipments
     */
    public List<EquipmentResponseDto> getAllEquipments(){
        return this.equipmentMapper.toEquipmentResponseDtoList(this.equipmentRepository.findAll());
    }

    /**
     * get equipment by id
     * @param id id of a equipment
     * @return EquipmentResponseDto
     */

    public EquipmentResponseDto getEquipmentById(Long id){
        return this.equipmentMapper.toEquipmentResponseDto(
                this.equipmentRepository.findById(id)
                        .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found !"))
        );
    }

    /**
     * get equipment by id
     * @param id id of a equipment
     * @return equipment
     */
    public Equipment findEquipmentById(Long id){
                return this.equipmentRepository.findById(id)
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found !"));
    }

    /**
     * save a new equipment
     * @param equipmentCreateDto equipment to save
     */
    @Transactional
    public EquipmentResponseDto saveEquipment(EquipmentCreateDto equipmentCreateDto){
        Equipment equipment = this.equipmentMapper.toEquipament(equipmentCreateDto);
        return this.equipmentMapper.toEquipmentResponseDto(this.equipmentRepository.save(equipment));
    }

    /**
     * update a equipment
     * @param equipmentCreateDto equipment instace to get the new data
     * @return equipment updated
     */
    public EquipmentResponseDto updateEquipment(EquipmentCreateDto equipmentCreateDto){
        Equipment equipment = this.findEquipmentById(equipmentCreateDto.getId());
        equipment.setEquipmentName(equipmentCreateDto.getEquipmentName());
        equipment.setSizeInMeterCubic(equipmentCreateDto.getSizeInMeterCubic());
        this.equipmentRepository.save(equipment);
        return this.equipmentMapper.toEquipmentResponseDto(equipment);

    }

    /**
     * delete a equipment
     * @param id id to update
     */
    @Transactional
    public void deleteEquipment(Long id){
        this.equipmentRepository.delete(this.findEquipmentById(id));
    }



}
