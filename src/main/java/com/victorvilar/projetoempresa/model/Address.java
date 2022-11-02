package com.victorvilar.projetoempresa.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.victorvilar.projetoempresa.embendable.AddressId;

/**
 * Class that represents the address of a Client
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Entity
@Table(name="address")
public class Address implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private AddressId id = new AddressId();
	
    private String complement;
    private String zipCode;
    private String city;
    private String state;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable=false)
	private Client client;

    //getters and setters - address name
    public String getAddressName() {
        return this.id.getAddressName();
    }

    public void setAddressName(String addressName) {
        this.id.setAddressName(addressName);
    }
    //------------------------

    //getters and setters - address number
    public String getAddressNumber() {
        return this.id.getAddressNumber();
    }

    public void setAddressNumber(String addressNumber) {
        this.id.setAddressNumber(addressNumber);
    }

    //------------------------

    //getters and setters - complement
    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
    //------------------------

    //getters and setters - zip Cobde
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    //------------------------

    //getters and setters - city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    //------------------------

    //getters and setters - state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    //------------------------

    
	//getters e setters - client
	public void setClient(Client client2) {
		this.client = client2;
		
	}
	
	public Client getCliente() {
		return this.client;
	}
	//--------------
	
}
