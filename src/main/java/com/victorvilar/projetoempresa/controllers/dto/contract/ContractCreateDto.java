package com.victorvilar.projetoempresa.controllers.dto.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.domain.ItemContract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractCreateDto {

    @NotBlank(message ="The contract must have a number")
    private String number;
    @NotBlank(message = "The contract must have a start date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate beginDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotBlank(message = "the contract must have a end date")
    private LocalDate endDate;
    @NotNull(message = "the contract musta have at least one item")
    private List<ItemContract> itens = new ArrayList<ItemContract>();
    @NotBlank(message ="the contract must have a client")
    private String clientId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<ItemContract> getItens() {
        return itens;
    }

    public void setItens(List<ItemContract> itens) {
        this.itens = itens;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
