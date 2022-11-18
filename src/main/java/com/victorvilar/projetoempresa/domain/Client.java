package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false,unique = true)
	private String cpfCnpj;

	@Column(nullable=false)
	private String nameCompanyName;

	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Supervisor> supervisors = new ArrayList<Supervisor>();
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Contract> contracts = new ArrayList<Contract>(); 
	

	/**
	 * Add a new address to client, add this to client of client
	 * @param address
	 */
	public void addNewAddress(Address address) {
		address.setClient(this);
		this.getAddresses().add(address);
	}
	
	/**
	 * Add a new Supervisor to client, add this to supervisor client
	 * @param supervisor
	 */
	public void addNewSupervisor(Supervisor supervisor) {
		supervisor.setClient(this);
		this.getSupervisors().add(supervisor);
	}
	/**
	 * Add a new Contract to client, add this to contract client
	 * @param contract
	 */
	public void addNewContract(Contract contract) {
		contract.setClient(this);
		this.getContracts().add(contract);
	}
	//Constructors
	public Client() {
		
	}
	public Client(String nameCompanyName) {
		this.nameCompanyName = nameCompanyName;
	}
	//-------------------------------------
	
	
	//getters and setters - cpfCnpj
	public String getCpfCnpj() {
		return this.cpfCnpj;
	}
	
	/**
	 * Set the cpfCnpj variable. As there are rules to know if the
	 * value it's true, it uses a class to test if the string is correct.
	 * @param cpfCnpj variable that represents a cpf or cnpj number
	 */
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	//-------------------------------------

	//getters and setters - Addresses
	public List<Address> getAddresses() {
		return this.addresses;
	}
	//-------------------------------------

	//getters and setters - Supervisors
	public List<Supervisor> getSupervisors() {
		return this.supervisors;
	}
	//-------------------------------------

	//getters and setters - Contracts
	public List<Contract> getContracts() {
		return contracts;
	}
	//-------------------------------------


	
	
	

	@Override
	public String toString() {
		return "Client{" +

				", nameCompanyName='" + nameCompanyName + '\'' +
				", cpfCnpj='" + cpfCnpj + '\'' +
				", addresses=" + addresses +
				", supervisors=" + supervisors +
				", contracts=" + contracts +
				'}';
	}

	//getters and setter - nameCompanyName
	public String getNameCompanyName() {
		return nameCompanyName;
	}
	public void setNameCompanyName(String nameCompanyName) {
		this.nameCompanyName = nameCompanyName;
	}


}
