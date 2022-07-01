package com.victorvilar.projetoempresa.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Class that represents the contract of a Client
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Entity
@Table(name="contracts")
public class Contract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String number;
    
    @Column(nullable=false)
    private LocalDate validity;
    
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ItemContract> itens = new ArrayList<ItemContract>();
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable=false)
	private Client client;
      
	
	/**
	 * add a new item to contract, add this contract to item
	 * @param itemContract
	 */
	public void addNewItem(ItemContract itemContract) {
		itemContract.setContract(this);
		this.itens.add(itemContract);
	}
	
    
    //Constructors
    public Contract() {
		
	}
    //-----------------------


  //getters and setters - number
	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}
	//-----------------------


	//getters and setters - validity
	public LocalDate getValidity() {
		return validity;
	}


	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}
	//-----------------------


	//getters and setters - itens
	public List<ItemContract> getItens() {
		return itens;
	}


	//getters e setters - client
	public void setClient(Client client2) {
		this.client = client2;
		
	}
	
	public Client getCliente() {
		return this.client;
	}
	//--------------
	

	

}
