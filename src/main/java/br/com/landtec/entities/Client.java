package br.com.landtec.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.landtec.util.CpfCnpjValidator;

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
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Supervisor> supervisors = new ArrayList<Supervisor>();
	
	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Contract> contracts = new ArrayList<Contract>(); 
	
	
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
	if(CpfCnpjValidator.checkIfIsValid(cpfCnpj)) {
		this.cpfCnpj = cpfCnpj;
	}else {
		System.out.println("CPF/CNPJ Invalid");
	}
		
	}
	//-------------------------------------
	
	
	//getters and setters - Addresses
	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresse(Address address) {
		this.addresses.add(address);
	}
	//-------------------------------------
	

	//getters and setters - Supervisors
	public List<Supervisor> getSupervisors() {
		return this.supervisors;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisors.add(supervisor);
	}
	//-------------------------------------
	
	
	//getters and setters - Contracts
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContract(Contract contracts) {
		this.contracts.add(contracts);
	}
	//-------------------------------------


	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", nameCompanyName='" + nameCompanyName + '\'' +
				", cpfCnpj='" + cpfCnpj + '\'' +
				", addresses=" + addresses +
				", supervisors=" + supervisors +
				", contracts=" + contracts +
				'}';
	}
}
