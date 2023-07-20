package com.victorvilar.projetoempresa.controllers.dto.supervisor;

import jakarta.validation.constraints.NotBlank;

public class SupervisorCreateDto {


    @NotBlank(message = "The name of supervisor is required")
    private String name;
    private String role;
    @NotBlank(message = "The phonenumer of supervisor is required")
    private String phoneNumber;
    @NotBlank(message = "the email of supervisor is required")
    private String email;

    @NotBlank(message= "The customer of supervisor is required")
    private String customerId;

    //constructors
    public SupervisorCreateDto() {
    }
    //-----------

    //getters e setters - clientId
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String id) {
        this.customerId = id;
    }
    //-----------

    //getters e setters - name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //-----------

    //getters e setters - role
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    //-------------

    //getters e setters = phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //--------------

    //getters e setters - email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //--------------



}
