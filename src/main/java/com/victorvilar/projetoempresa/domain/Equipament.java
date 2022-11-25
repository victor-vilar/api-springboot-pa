package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A class that represents the equipaments available for store the trash
 * @author Victor
 * @since 2022-02-21
 */
@Entity
@Table(name="equipaments")
public class Equipament implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String equipamentName;
	
	@Column(nullable = false)
	private double sizeInMeterCubic;

	
	//constructors
	public Equipament() {
		
	}
	//-----------
	
	
	//getters e setters - name
	public String getEquipamentName() {
		return equipamentName;
	}
	public void setEquipamentName(String equipamentName) {
		this.equipamentName = equipamentName;
	}
	//-----------
	
	
	//getters e setters - size
	public double getSizeInMeterCubic() {
		return sizeInMeterCubic;
	}
	public void setSizeInMeterCubic(double sizeInMeterCubic) {
		this.sizeInMeterCubic = sizeInMeterCubic;
	}
	//-----------
	
	
	
	
}
