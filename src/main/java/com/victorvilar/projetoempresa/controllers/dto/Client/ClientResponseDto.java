package com.victorvilar.projetoempresa.controllers.dto.Client;

import com.victorvilar.projetoempresa.model.Client;
import com.victorvilar.projetoempresa.model.Supervisor;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created to not expose the models of the API
 */
public class ClientResponseDto {


    private String nameCompanyName;
    private String cpfCnpj;
    private List<Supervisor> supervisors = new ArrayList<Supervisor>();



    //getters and setters - NameCompanyName
    public String getNameCompanyName() {
        return nameCompanyName;
    }
    public void setNameCompanyName(String nameCompanyName) {
        this.nameCompanyName = nameCompanyName;
    }
    //-------------

    //getters and setters - cpfCnpj
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    //-------------

    //getters and setters - supervisors
    public List<Supervisor> getAllSupervisors(){
        return this.supervisors;
    }
    public void setListOfSupervisors(List<Supervisor> supervisors){
        this.supervisors = supervisors;
    }
    //-------------


    public void ClientToClientResponseDto(Client client){
        this.nameCompanyName = client.getNameCompanyName();
        this.cpfCnpj =client.getCpfCnpj();
        this.supervisors = client.getSupervisors();
    }

}
