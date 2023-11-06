package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * CRIAR OBJETO ORDEM DE SERVIÇO -- todo
 */

public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final LocalDate emissionDate = LocalDate.now();
    private LocalDate serviceExpectedDate;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    @Column(nullable = false)
    private ItemContract itemContract;

    @ManyToOne
    @Column(nullable = false)
    private Customer customer;


    //information to be filled after the service execution
    private String IneaManifest;
    private LocalTime serviceTime;
    private String observation;
    private String osFileUrl;










}
