package com.victorvilar.projetoempresa.controllers.dto.contract;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class ContractCreateDto {

    @NotBlank(message ="The contract must have a number")
    private String number;

    @NotNull(message = "The contract must have a start date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate beginDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotNull(message = "the contract must have a end date")
    private LocalDate endDate;

    private List<ItemContractCreateDto> itens;

    public List<ItemContractCreateDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemContractCreateDto> itens) {
        this.itens = itens;
    }

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

}
