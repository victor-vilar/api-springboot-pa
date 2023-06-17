package com.victorvilar.projetoempresa.controllers.dto.contract;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractCreateDto {

    private Long id;

    @NotBlank(message ="The contract must have a number")
    private String number;

    @NotNull(message = "The contract must have a start date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate beginDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotNull(message = "the contract must have a end date")
    private LocalDate endDate;

    @NotEmpty(message = "A contract must have at least one item")
    private List<ItemContractCreateDto> itens = new ArrayList<>();

    @NotNull(message = "the contract must have a customer")
    private String customerId;

    public ContractCreateDto() {
    }

    public ContractCreateDto(Long id,String number, LocalDate beginDate, LocalDate endDate, List<ItemContractCreateDto> itens, String customerId) {
        this.number = number;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.itens = itens;
        this.customerId = customerId;
        this.id = id;
    }

    //getters e setters - id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //--------------

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


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
