package com.victorvilar.projetoempresa.dto.contract;

public class ItemContractResponseDto {

    private Long id;
    private String residue;
    private String equipment;
    private Double qtdOfResidue;
    private Double itemValue;
    private String contract;
    private String description;

    public ItemContractResponseDto() {
    }

    public ItemContractResponseDto(Long id, String residue, String equipment, Double qtdOfResidue, Double itemValue, String description) {
        this.id = id;
        this.residue = residue;
        this.equipment = equipment;
        this.qtdOfResidue = qtdOfResidue;
        this.itemValue = itemValue;
        this.description =description;
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

    public double getItemValue() {
        return itemValue;
    }

    public void setItemValue(double itemValue) {
        this.itemValue = itemValue;
    }

    //getters and setters - description
    public String getDescription() {return this.description;}
    public void setDescription(String description){this.description = description;}
    //-----------

}
