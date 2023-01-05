package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;

import javax.persistence.*;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String addressName;
    private String addressNumber;
    private String complement;
    private String zipCode;
    private String city;
    private String state;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable=false)
	private Client client;

    //constructors
    public Address() {

    }
    public Address(String addressName, String addressNumber, String complement, String zipCode, String city, String state, Client client) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.client = client;
    }
    //------------------------

    //getters and setters - address name
    public String getAddressName() {
        return this.getAddressName();
    }
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    //------------------------

    //getters and setters - address number
    public String getAddressNumber() {
        return this.getAddressNumber();
    }
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
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
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
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
	public Client getClient() {
		return this.client;
	}
	//--------------
	
}
