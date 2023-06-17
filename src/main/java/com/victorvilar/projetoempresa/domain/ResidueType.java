package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="residues")
public class ResidueType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "residue_type", nullable = false)
	private String type;
	private String description;
	

	
	//constructors
	public ResidueType() {
	}

	public ResidueType(String type, String description){
		this.type = type;
		this.description = description;
	}
	//-----------
	
	//getters e setters = type
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//-----------
	
	//getters e setters = description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//-----------

	//getters e setters - id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//-----------
	
	
	
}
