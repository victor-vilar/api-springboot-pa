package com.victorvilar.projetoempresa.controllers.dto.equipament;

public class EquipmentResponseDto {


    private Long id;
    private String equipamentName;
    private double sizeInMeterCubic;

    public EquipmentResponseDto() {
    }

    public EquipmentResponseDto(Long id, String equipamentName, double sizeInMeterCubic) {
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
