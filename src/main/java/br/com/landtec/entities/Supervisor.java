package br.com.landtec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * class that represents a supervisor of a client.
 * @author Victor Vilar
 * @since 2022-02-01
 *
 */

@Entity
@Table(name="supervisors")
public class Supervisor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String role;
	@Column(nullable = false)
	private String phoneNumber;
	@Column(nullable = false)
	private String email;
	
	@ManyToOne
	private Client client;
	
	//constructors
	public Supervisor() {
		
	}
	//-----------
	
	//getters e setters - name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//-----------
	
	//getters e setters - role
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//-------------
	
	
	//getters e setters = phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//--------------
	
	
	//getters e setters - email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//--------------
	
	
	
}
