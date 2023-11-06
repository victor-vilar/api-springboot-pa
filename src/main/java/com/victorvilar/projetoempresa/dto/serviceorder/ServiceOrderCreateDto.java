package com.victorvilar.projetoempresa.dto.serviceorder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.domain.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ServiceOrderCreateDto {


    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate serviceExpectedDate;

    private Vehicle vehicle;
    @NotNull(message="The order must have an item from one contract")
    private ItemContract itemContract;
    @NotNull(message="the order must have a customer")
    private String customer;

}
