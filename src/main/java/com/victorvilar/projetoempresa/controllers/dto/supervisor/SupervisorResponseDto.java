package com.victorvilar.projetoempresa.controllers.dto.supervisor;

public class SupervisorResponseDto {

    private Long id;
    private String name;
    private String role;
    private String phoneNumber;
    private String email;
    private String clientId;


    //constructors
    public SupervisorResponseDto() {

    }
    //-----------

    //getters e setters - id
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
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

    //getters e setters - clientId
    public String getCustomerId() {
        return clientId;
    }
    public void setCustomerId(String clientId) {
        this.clientId = clientId;
    }
    //--------------





}
