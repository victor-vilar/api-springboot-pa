package br.com.landtec.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Victor Vilar
 * @since 2022-01-31
 * Class that represents a client
 */

@Entity
@Table(name="clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nameCompanyName;
	private String cpfCnpj;
	
	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Address> addresses;

	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Supervisor> supervisors;
	
	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Contract> contract; 
	
	
	//Constructors
	public Client() {
		
	}
	
	public Client(String nameCompanyName) {
		this.nameCompanyName = nameCompanyName;
	}
	//-------------
}
