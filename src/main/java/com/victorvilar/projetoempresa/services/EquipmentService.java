package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.exceptions.EquipmentNotFoundException;
import com.victorvilar.projetoempresa.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    /**
     * get all equipments
     * @return a list of equiapments
     */
    public List<Equipament> getAllEquipaments(){

        return this.equipmentRepository.findAll();
    }

    /**
     * get equipament by id
     * @param id id of a equipament
     * @return equipament
     */
    public Equipament findEquipamentById(Long id){
                return this.equipmentRepository.findById(id)
                .orElseThrow(() -> new EquipmentNotFoundException("this equipament doesn't exist"));
    }

    /**
     * save a new equipament
     * @param equipament equipament to save
     */
    @Transactional
    public void saveEquipament(Equipament equipament){
        this.equipmentRepository.save(equipament);
    }

    /**
     * update a equipament
     * @param equipament equipament instace to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    public Equipament updateEquipament(Equipament equipament, Long id){
        Equipament equipament2 = this.findEquipamentById(id);
        equipament2.setEquipamentName(equipament.getEquipamentName());
        equipament2.setSizeInMeterCubic(equipament.getSizeInMeterCubic());
        this.saveEquipament(equipament2);
        return equipament2;

    }

    /**
     * delete a equipament
     * @param id id to update
     */
    @Transactional
    public void deleteEquipament( Long id){
        this.equipmentRepository.delete(this.findEquipamentById(id));
    }



}
