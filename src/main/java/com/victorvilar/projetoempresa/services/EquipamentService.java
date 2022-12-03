package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.exceptions.EquipamentNotFoundException;
import com.victorvilar.projetoempresa.repository.EquipamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentService {

    private final EquipamentRepository equipamentRepository;

    @Autowired
    public EquipamentService(EquipamentRepository equipamentRepository){
        this.equipamentRepository = equipamentRepository;
    }

    /**
     * get all equipments
     * @return a list of equiapments
     */
    public List<Equipament> getAllEquipaments(){
        return this.equipamentRepository.findAll();
    }

    /**
     * get equipament by id
     * @param id id of a equipament
     * @return equipament
     */
    public Equipament getEquipamentById(Long id){
        return this.equipamentRepository.findById(id)
                .orElseThrow(() -> new EquipamentNotFoundException("this equipament doesn't exist"));
    }

    /**
     * save a new equipament
     * @param equipament equipament to save
     */
    public void saveEquipament(Equipament equipament){
        this.equipamentRepository.save(equipament);
    }

    /**
     * update a equipament
     * @param equipament equipament instace to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    public Equipament updateEquipament(Equipament equipament, Long id){
        Equipament equipament2 = this.getEquipamentById(id);
        equipament2.setEquipamentName(equipament.getEquipamentName());
        equipament2.setSizeInMeterCubic(equipament.getSizeInMeterCubic());
        return equipament2;

    }

    /**
     * delete a equipament
     * @param id id to update
     */
    public void deleteEquipament( Long id){
        this.equipamentRepository.delete(this.getEquipamentById(id));
    }



}
