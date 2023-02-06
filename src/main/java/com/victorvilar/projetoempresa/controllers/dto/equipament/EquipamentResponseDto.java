package com.victorvilar.projetoempresa.controllers.dto.equipament;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EquipamentResponseDto {


    private Long id;
    private String equipamentName;
    private double sizeInMeterCubic;

    public EquipamentResponseDto() {
    }

    public EquipamentResponseDto(Long id, String equipamentName, double sizeInMeterCubic) {
        this.id = id;
        this.equipamentName = equipamentName;
        this.sizeInMeterCubic = sizeInMeterCubic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipamentName() {
        return equipamentName;
    }

    public void setEquipamentName(String equipamentName) {
        this.equipamentName = equipamentName;
    }

    public double getSizeInMeterCubic() {
        return sizeInMeterCubic;
    }

    public void setSizeInMeterCubic(double sizeInMeterCubic) {
        this.sizeInMeterCubic = sizeInMeterCubic;
    }
}
