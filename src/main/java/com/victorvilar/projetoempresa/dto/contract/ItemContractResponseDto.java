package com.victorvilar.projetoempresa.dto.contract;

public class ItemContractResponseDto {

    private Long id;
    private String residue;
    private String equipment;
    private Double qtdOfResidue;
    private Double itemValue;
    private String contract;

    public ItemContractResponseDto() {
    }

    public ItemContractResponseDto(Long id, String residue, String equipment, Double qtdOfResidue, Double itemValue) {
        this.id = id;
        this.residue = residue;
        this.equipment = equipment;
        this.qtdOfResidue = qtdOfResidue;
        this.itemValue = itemValue;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResidue() {
        return residue;
    }

    public void setResidue(String residue) {
        this.residue = residue;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipament) {
        this.equipment = equipament;
    }

    public Double getQtdOfResidue() {
        return qtdOfResidue;
    }

    public void setQtdOfResidue(Double qtdOfResidue) {
        this.qtdOfResidue = qtdOfResidue;
    }

    public double getValue() {
        return itemValue;
    }

    public void setValue(double itemValue) {
        this.itemValue = itemValue;
    }


}
