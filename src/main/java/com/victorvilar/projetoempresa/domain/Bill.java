package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.OneToMany;

import java.time.LocalDate;

/**
 * contas -- todo
 */
public abstract class Bill {

    private String id;
    //emissor da nota conta
    private BillEmitter supplier;

    private String noteNumber;
    //parcelas da conta
    @OneToMany()
    private List<Stalment> stalmentList;
    //descrição da conta
    private String description;



}
