package com.victorvilar.projetoempresa.controllers.dto.contract;


import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.domain.ResidueType;

import javax.persistence.*;


public class ItemContractDto {
    private Long id;
    private String residue;
    private String equipament;
    private Double qtdOfResidue;
    private double itemValue;
    private String contract;


    //constructors
    public ItemContractDto() {

    }
    public ItemContractDto(Long id, String residue, String equipament, Double qtdOfResidue, double itemValue, String contract) {
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

    public String getResidue() {
        return residue;
    }

    public void setResidue(String residue) {
        this.residue = residue;
    }

    public String getEquipament() {
        return equipament;
    }

    public void setEquipament(String equipament) {
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
