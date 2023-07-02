package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Stalment {

    private Long id;
    //conta
    @ManyToOne
    @JoinColumn(name="bill_id")
    private Bill bill;
    //data de vencimento
    private LocalDate dueDate;
    //valor do pagamento
    private BigDecimal payValue;
    // data de pagamento
    private LocalDate payDate;
    //valor pago
    private BigDecimal payedValue;

}
