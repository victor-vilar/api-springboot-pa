package com.victorvilar.projetoempresa.controllers.dto.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private LocalDate beginDate;
    @NotBlank(message = "the contract must have a end date")
    private LocalDate validity;
    @NotNull(message = "the contract musta have at least one item")
    private List<ItemContract> itens = new ArrayList<ItemContract>();
    @NotBlank(message ="the contract must have a client")
    private String clientId;
}
