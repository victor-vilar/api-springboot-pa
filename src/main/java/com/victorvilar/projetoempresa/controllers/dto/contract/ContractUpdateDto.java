package com.victorvilar.projetoempresa.controllers.dto.contract;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractUpdateDto {

    @NotBlank(message ="A contract to update must have a number")
    private Long id;

    @NotBlank(message ="The contract must have a number")
    private String number;

    @NotNull(message = "The contract must have a start date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate beginDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotNull(message = "the contract must have a end date")
    private LocalDate endDate;

    @NotNull(message = "the contract must have a client")
    private String customerId;

    @NotEmpty(message = "A contract must have at least one item")
    private List<ItemContractUpdateDto> itens  = new ArrayList<>();;

    public ContractUpdateDto(Long id, String number, LocalDate beginDate, LocalDate endDate, String customerId, List<ItemContractUpdateDto> itens) {
        this.id = id;
        this.number = number;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.itens = itens;
    }

    public ContractUpdateDto() {
    }

    public List<ItemContractUpdateDto> getItens() {
        return itens;
    }
    public void setItens(List<ItemContractUpdateDto> itens) {
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

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String clientId) {
        this.customerId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
