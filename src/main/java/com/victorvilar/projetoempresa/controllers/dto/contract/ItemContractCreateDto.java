package com.victorvilar.projetoempresa.controllers.dto.contract;


public class ItemContractCreateDto {
    private Long id;
    private Long residue;
    private Long equipament;
    private Double qtdOfResidue;
    private double itemValue;
    private String contract;


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
