package com.victorvilar.projetoempresa.controllers.dto.client;

import com.sun.istack.NotNull;
import com.victorvilar.projetoempresa.domain.Client;

import javax.validation.constraints.NotBlank;

/**
 * Class created to not expose the models of the API
 */
public class ClientCreateDto {

    //TODO INCLUDE SPRING IO VALIDATION
    @NotBlank(message="The name of the client or company is required")
    private String nameCompanyName;
    @NotBlank(message="The CPF or CNPJ can't be blank")
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
