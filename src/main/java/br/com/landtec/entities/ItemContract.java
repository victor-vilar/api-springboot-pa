package br.com.landtec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class ItemContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//the type of residue(trash) of the item.
	@ManyToOne
	@JoinColumn(name = "residue_id", nullable = false)
	private ResidueType residue;
	
	//the equipament that gonna be used to store the trash.
	@ManyToOne
	@JoinColumn(name = "equipament_id", nullable = false)
	private Equipament equipament;
	
	//the quantity estimated for  year
	@Column(nullable = false, name="max_qtd_year")
	private Double qtdOfResidue;
	
	//the value of the item
	@Column(nullable=false)
	private double value;

	@ManyToOne
	@JoinColumn(name="contract_id", nullable=false)
	private Contract contract;
	
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
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	//-----------
	
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Item:\n");
		string.append("Tipo de Resíduo: " + this.residue.getType() + "\n");
		string.append("Equipamento: " + this.equipament.getEquipamentName()+ "\n");
		string.append("Valor Unitário: R$" + this.value + "\n");
		string.append("Qtd Anual: " + this.qtdOfResidue + "\n");
		string.append("Valor Anual: R$" + (Double)this.value * this.qtdOfResidue + "\n" );
		return string.toString();
	}
	
	
	
	
}
