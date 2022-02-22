package br.com.landtec.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


/**
 * Class that represents the contract of a Client
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Entity
@Table(name="contracts")
public class Contract {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String number;
    private LocalDate validity;
    
    @JoinColumn(name="contract_id")
    private List<ItemContract> itens;
    
    
    
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




	public void setItens(List<ItemContract> itens) {
		this.itens = itens;
	}
	//-----------------------

    

}
