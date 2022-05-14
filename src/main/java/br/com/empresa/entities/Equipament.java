package br.com.empresa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipaments")
public class Equipament {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
