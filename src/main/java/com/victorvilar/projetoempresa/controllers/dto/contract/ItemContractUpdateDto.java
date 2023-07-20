package com.victorvilar.projetoempresa.controllers.dto.contract;


import jakarta.validation.constraints.NotNull;

public class ItemContractUpdateDto {

    @NotNull(message = "An item to update  must have an id")
    private Long id;

    @NotNull(message = "The item must have a residue")
    private Long residue;

    @NotNull(message = "the item must have a equipament")
    private Long equipment;

    @NotNull(message = "the item must have a quantity")
    private Double qtdOfResidue;

    @NotNull(message = "the item must have a value")
    private double itemValue;


    //constructors
    public ItemContractUpdateDto() {

    }
    public ItemContractUpdateDto(Long id, Long residue, Long equipment, Double qtdOfResidue, double itemValue, String contract) {
        this.id = id;
        this.residue = residue;
        this.equipment = equipment;
        this.qtdOfResidue = qtdOfResidue;
        this.itemValue = itemValue;
    }
    //----------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResidue() {
        return residue;
    }

    public void setResidue(Long residue) {
        this.residue = residue;
    }

    public Long getEquipment() {
        return equipment;
    }

    public void setEquipment(Long equipament) {
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
}
