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
     * @return a list of equiapments
     */
    public List<EquipmentResponseDto> getAllEquipments(){
        return this.equipmentMapper.toEquipmentResponseDtoList(this.equipmentRepository.findAll());
    }

    /**
     * get equipment by id
     * @param id
     * @return EquipmentResponseDto
     */

    public EquipmentResponseDto getEquipmentById(Long id){
        return this.equipmentMapper.toEquipmentResponseDto(
                this.equipmentRepository.findById(id)
                        .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found !"))
        );
    }

    /**
     * get equipament by id
     * @param id id of a equipament
     * @return equipament
     */
    public Equipment findEquipmentById(Long id){
                return this.equipmentRepository.findById(id)
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found !"));
    }

    /**
     * save a new equipament
     * @param equipmentCreateDto equipament to save
     */
    @Transactional
    public EquipmentResponseDto saveEquipment(EquipmentCreateDto equipmentCreateDto){
        Equipment equipment = this.equipmentMapper.toEquipament(equipmentCreateDto);
        this.equipmentMapper.toEquipmentResponseDto(this.equipmentRepository.save(equipment));
    }

    /**
     * update a equipament
     * @param equipment equipament instace to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    public Equipment updateEquipment(Equipment equipment, Long id){
        Equipment equipment2 = this.findEquipmentById(id);
        equipment2.setEquipmentName(equipment.getEquipmentName());
        equipment2.setSizeInMeterCubic(equipment.getSizeInMeterCubic());
        this.saveEquipment(equipment2);
        return equipment2;

    }

    /**
     * delete a equipament
     * @param id id to update
     */
    @Transactional
    public void deleteEquipment(Long id){
        this.equipmentRepository.delete(this.findEquipmentById(id));
    }



}
