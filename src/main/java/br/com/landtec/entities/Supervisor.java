package br.com.landtec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supervisors")
public class Supervisor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String name;
	private String phoneNumber;
	private String email;
	
	
}
