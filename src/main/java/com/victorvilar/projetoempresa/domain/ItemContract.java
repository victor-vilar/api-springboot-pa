package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A class that represents the itens of contract
 * @author Victor
 * @since 2022-02-21
 */
@Entity
@Table(name = "itens_contract")
public class ItemContract implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//the type of residue(trash) of the item.
	@ManyToOne
	@JoinColumn(nullable = false)
	private ResidueType residue;
	
	//the equipament that gonna be used to store the trash.
	@ManyToOne
	@JoinColumn(nullable = false)
	private Equipament equipament;
	
	//the quantity estimated for  year
	@Column(nullable = false, name="max_qtd_year")
	private Double qtdOfResidue;
	
	//the value of the item
	@Column(nullable=false)
	private double itemValue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contract_id", nullable=false)
	private Contract contract;
	
	
	
	public ItemContract() {
		
	}
	
	public ItemContract(ResidueType residue, Equipament equipament, double qtd, double value) {
		this.residue = residue;
		this.equipament = equipament;
		this.qtdOfResidue = qtd;
		this.itemValue = value;
	}
	
	//getters e setters - Contract
	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	//-----------
	

	//getters e setters - residue
	public ResidueType getResidue() {
		return residue;
	}

	public void setResidue(ResidueType residue) {
		this.residue = residue;
	}
	//-----------
	
	//getters e setters - equipament
	public Equipament getEquipament() {
		return equipament;
	}

	public void setEquipament(Equipament equipament) {
		this.equipament = equipament;
	}
	//-----------
	
	//getters e setters - amount
	public Double getQtdOfResidue() {
		return qtdOfResidue;
	}

	public void setQtdOfResidue(Double qtdOfResidue) {
		this.qtdOfResidue = qtdOfResidue;
	}
	//-----------
	
	//getters e setters - value
	public double getValue() {
		return itemValue;
	}

	public void setValue(double value) {
		this.itemValue = value;
	}
	//-----------
	
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Item:\n");
		string.append("Tipo de Resíduo: " + this.residue.getType() + "\n");
		string.append("Equipamento: " + this.equipament.getEquipamentName()+ "\n");
		string.append("Valor Unitário: R$" + this.itemValue + "\n");
		string.append("Qtd Anual: " + this.qtdOfResidue + "\n");
		string.append("Valor Anual: R$" + (Double)this.itemValue * this.qtdOfResidue + "\n" );
		return string.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
