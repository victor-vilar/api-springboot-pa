package com.victorvilar.projetoempresa.domain.vechicle;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Refueling {

    private String id;
    @Column(nullable = false)
    private LocalDate refuelDate;
    @ManyToOne
    @JoinColumn(name="vechile_id")
    private Vechicle vechicle;
    @Column(nullable = false)
    private FuelType fuelType;
    @Column(nullable = false)
    private BigDecimal fuelValue;
    @Column(nullable = false)
    private Long quantity;
}
