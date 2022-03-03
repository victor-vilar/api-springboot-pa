package br.com.landtec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class that represents the address of a Client
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String addressName;
    private String addressNumber;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
	
    @ManyToOne(fetch=FetchType.LAZY)
	private Client client;

    //getters and setters - address name
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    //------------------------

    //getters and setters - address number
    public String getAddressNumber() {
        return addressNumber;
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
