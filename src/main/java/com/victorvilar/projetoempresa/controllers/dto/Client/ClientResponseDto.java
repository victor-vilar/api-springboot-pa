package com.victorvilar.projetoempresa.controllers.dto.Client;

import com.victorvilar.projetoempresa.model.Client;

/**
 * Class created to not expose the models of the API
 */
public class ClientResponseDto {


    private String nameCompanyName;
    private String cpfCnpj;



    //getters and setters - NameCompanyName
    public String getNameCompanyName() {
        return nameCompanyName;
    }

    public void setNameCompanyName(String nameCompanyName) {
        this.nameCompanyName = nameCompanyName;
    }

    //getters and setters - cpfCnpj
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }


    public void ClientToClientResponseDto(Client client){
        this.nameCompanyName = client.getNameCompanyName();
        this.cpfCnpj =client.getCpfCnpj();
    }

}
