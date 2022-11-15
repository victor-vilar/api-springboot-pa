package com.victorvilar.projetoempresa.controllers.dto.client;

import com.victorvilar.projetoempresa.domain.Client;

/**
 * Class created to not expose the models of the API
 */
public class ClientCreateDto {

    private String nameCompanyName;
    private String cpfCnpj;

    //getters and setters - NameCompanyName
    public String getNameCompanyName() {
        return nameCompanyName;
    }
    public void setNameCompanyName(String nameCompanyName) {
        this.nameCompanyName = nameCompanyName;
    }
    //------
    //getters and setters - cpfCnpj
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    //------



}
