package com.victorvilar.projetoempresa.controllers.dto.contract;


import javax.validation.constraints.NotNull;

public class ItemContractCreateDto {

    private Long id;

    @NotNull(message = "The item must have a residue")
    private Long residue;

    @NotNull(message = "the item must have a equipament")
    private Long equipament;

    @NotNull(message = "the item must have a quantity")
    private Double qtdOfResidue;

    @NotNull(message = "the item must have a value")
    private double itemValue;



    //constructors
    public ItemContractCreateDto() {

    }
    public ItemContractCreateDto(Long id, Long residue, Long equipament, Double qtdOfResidue, double itemValue, String contract) {
        this.id = id;
        this.residue = residue;
        this.equipament = equipament;
        this.qtdOfResidue = qtdOfResidue;
        this.itemValue = itemValue;
        this.contract = contract;
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

    public Long getEquipament() {
        return equipament;
    }

    public void setEquipament(Long equipament) {
        this.equipament = equipament;
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

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
