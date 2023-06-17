package com.victorvilar.projetoempresa.controllers.dto.equipament;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipmentCreateDto {

    private Long id;
    @NotBlank(message="The equipment must have a name")
    private String equipmentName;
    @NotNull(message="The equipment must have a size")
    private double sizeInMeterCubic;

    public EquipmentCreateDto() {
    }

    public EquipmentCreateDto(Long id, String equipmentName, double sizeInMeterCubic) {
        this.id = id;
        this.equipmentName = equipmentName;
        this.sizeInMeterCubic = sizeInMeterCubic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getSizeInMeterCubic() {
        return sizeInMeterCubic;
    }

    public void setSizeInMeterCubic(double sizeInMeterCubic) {
        this.sizeInMeterCubic = sizeInMeterCubic;
    }
}
