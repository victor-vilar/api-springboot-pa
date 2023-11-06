package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * CRIAR OBJETO ORDEM DE SERVIÇO -- todo
 */

@Entity
@Table(name = "service-order")
public class ServiceOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * the date of emission of the service order
     */
    private final LocalDate emissionDate = LocalDate.now();

    /**
     * expected date of service, sometimes the service is not executed in the expected time
     */
    private LocalDate serviceExpectedDate;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    @Column(nullable = false)
    private ItemContract itemContract;

    @ManyToOne
    @Column(nullable = false)
    private Customer customer;


    /**
     * inea manifest it is a document that the customer must emit in each service execution. This document must
     * be made in the INEA site.
     */
    private String ineaManifest;

    /**
     * the time where the service were executed
     */
    private LocalTime serviceTime;

    /**
     * A field to add any request of the customer or by the driver
     */
    private String observation;

    /**
     * place in the filesystem where the scan of the physical copy is stored.
     * This url file must have the already made and filled service order.
     */
    private String osFileUrl;

    public ServiceOrder() {
    }

    public ServiceOrder(Long id, LocalDate serviceExpectedDate, Vehicle vehicle, ItemContract itemContract, Customer customer, String ineaManifest, LocalTime serviceTime, String observation, String osFileUrl) {
        this.id = id;
        this.serviceExpectedDate = serviceExpectedDate;
        this.vehicle = vehicle;
        this.itemContract = itemContract;
        this.customer = customer;
        this.ineaManifest = ineaManifest;
        this.serviceTime = serviceTime;
        this.observation = observation;
        this.osFileUrl = osFileUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public LocalDate getServiceExpectedDate() {
        return serviceExpectedDate;
    }

    public void setServiceExpectedDate(LocalDate serviceExpectedDate) {
        this.serviceExpectedDate = serviceExpectedDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ItemContract getItemContract() {
        return itemContract;
    }

    public void setItemContract(ItemContract itemContract) {
        this.itemContract = itemContract;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIneaManifest() {
        return ineaManifest;
    }

    public void setIneaManifest(String ineaManifest) {
        this.ineaManifest = ineaManifest;
    }

    public LocalTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getOsFileUrl() {
        return osFileUrl;
    }

    public void setOsFileUrl(String osFileUrl) {
        this.osFileUrl = osFileUrl;
    }
}
