package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;

import jakarta.persistence.*;

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
	private Residue residue;
	
	//the equipment that gonna be used to store the trash.
	@ManyToOne
	@JoinColumn(nullable = false)
	private Equipment equipment;
	
	//the quantity estimated for  year
	@Column(nullable = false, name="max_qtd_year")
	private Double qtdOfResidue;
	
	//the value of the item
	@Column(nullable=false)
	private double itemValue;

	//item Description
	private String description;

	//the coolection frequency don't know the itemContract, unilateral relation
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="frequency_id")
	private CollectionFrequency collectionFrequency;



	@ManyToOne
	@JoinColumn(name="contract_id", nullable=false)
	private Contract contract;
	
	
	
	public ItemContract() {
		
	}
	
	public ItemContract(Residue residue, Equipment equipment, double qtd, double value, String description) {
		this.residue = residue;
		this.equipment = equipment;
		this.qtdOfResidue = qtd;
		this.itemValue = value;
		this.description = description;
	}


	//getters and setters - id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//-----------

	
	//getters e setters - Contract
	public Contract getContract() {
		return this.contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	//-----------
	

	//getters e setters - residue
	public Residue getResidue() {
		return residue;
	}
	public void setResidue(Residue residue) {
		this.residue = residue;
	}
	//-----------
	
	//getters e setters - equipament
	public Equipment getEquipament() {
		return equipment;
	}
	public void setEquipament(Equipment equipment) {
		this.equipment = equipment;
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
	public double getItemValue() {
		return itemValue;
	}
	public void setItemValue(double value) {
		this.itemValue = value;
	}
	//-----------

	//getters and setters - description
	public String getDescription() {return this.description;}
	public void setDescription(String description){this.description = description;}
	//-----------

	//getters and setters - collection Frequency
	public CollectionFrequency getCollectionFrequency(){return this.collectionFrequency;}
	public void setCollectionFrequency(CollectionFrequency collectionFrequency){this.collectionFrequency = collectionFrequency;}
	//-----------

	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Item:\n");
		string.append("Tipo de Resíduo: " + this.residue.getType() + "\n");
		string.append("Equipamento: " + this.equipment.getEquipmentName()+ "\n");
		string.append("Valor Unitário: R$" + this.itemValue + "\n");
		string.append("Qtd Anual: " + this.qtdOfResidue + "\n");
		string.append("Valor Anual: R$" + (Double)this.itemValue * this.qtdOfResidue + "\n" );
		return string.toString();
	}




}
