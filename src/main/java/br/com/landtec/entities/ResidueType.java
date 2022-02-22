package br.com.landtec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="residuo")
public class ResidueType {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String type;
	private String description;
	
	//constructors
	public ResidueType() {
		
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
	
	
	
}
