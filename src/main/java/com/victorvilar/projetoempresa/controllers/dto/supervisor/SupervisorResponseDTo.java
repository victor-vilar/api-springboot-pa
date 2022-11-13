package com.victorvilar.projetoempresa.controllers.dto.supervisor;

import com.victorvilar.projetoempresa.model.Client;
import com.victorvilar.projetoempresa.model.Supervisor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class SupervisorResponseDTo {

    private Long id;
    private String name;
    private String role;
    private String phoneNumber;
    private String email;


    //constructors
    public SupervisorResponseDTo() {

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


    public void toSupervisorResponseDto(Supervisor supervisor){
        this.setName(supervisor.getName());
        this.setRole(supervisor.getRole());
        this.setPhoneNumber(supervisor.getPhoneNumber());
        this.setEmail(supervisor.getEmail());
    }




}
