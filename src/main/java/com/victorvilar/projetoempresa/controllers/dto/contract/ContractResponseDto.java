package com.victorvilar.projetoempresa.controllers.dto.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victorvilar.projetoempresa.domain.ItemContract;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractResponseDto {


    private Long id;
    private String number;
    private String clientId;


    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate beginDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate validity;

    private List<ItemContract> itens = new ArrayList<ItemContract>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public List<ItemContract> getItens() {
        return itens;
    }

    public void setItens(List<ItemContract> itens) {
        this.itens = itens;
    }
}
