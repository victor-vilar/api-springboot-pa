package com.victorvilar.projetoempresa.dto.contract;


import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ItemContractCreateDto {

    @NotNull(message = "The item must have a residue")
    private Long residue;

    @NotNull(message = "the item must have a equipment")
    private Long equipment;

    @NotNull(message = "the item must have a quantity")
    private Double qtdOfResidue;

    @NotNull(message = "the item must have a value")
    private BigDecimal itemValue;

    private String description;

    //constructors
    public ItemContractCreateDto() {

    }
    public ItemContractCreateDto(Long residue, Long equipment, Double qtdOfResidue, BigDecimal itemValue, String description) {
        this.residue = residue;
        this.equipment = equipment;
        this.qtdOfResidue = qtdOfResidue;
        this.itemValue = itemValue;
        this.description = description;
    }
    //----------------------------


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

    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue = itemValue;
    }

    //getters and setters - description
    public String getDescription() {return this.description;}
    public void setDescription(String description){this.description = description;}
    //-----------

}
