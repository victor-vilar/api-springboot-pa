package br.com.landtec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A class that represents the itens of contract
 * @author Victor
 * @since 2022-02-21
 */
@Entity
@Table(name = "itens-contract")
public class ItemContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//the type of residue(trash) of the item.
	@ManyToOne
	private ResidueType residue;
	
	//the equipamento that gonna be used to store the trash.
	@ManyToOne
	private Equipament equipament;
	
	//the quantity estimated for month or year
	private Double qtdOfResidue;
	
	//the value of the item
	private double value;
	
	
	
	
	
}
