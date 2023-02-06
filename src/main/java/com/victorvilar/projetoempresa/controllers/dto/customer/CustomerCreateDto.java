package com.victorvilar.projetoempresa.controllers.dto.customer;

import javax.validation.constraints.NotBlank;

/**
 * Class created to not expose the models of the API
 */
public class CustomerCreateDto {

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
