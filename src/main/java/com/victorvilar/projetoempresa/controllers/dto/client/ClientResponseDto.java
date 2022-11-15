package com.victorvilar.projetoempresa.controllers.dto.client;

import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class created to not expose the models of the API
 */
public class ClientResponseDto {


    private String nameCompanyName;
    private String cpfCnpj;
    private List<SupervisorResponseDto> supervisors = new ArrayList<SupervisorResponseDto>();



    //getters and setters - NameCompanyName
    public String getNameCompanyName() {
        return nameCompanyName;
    }
    public void setNameCompanyName(String nameCompanyName) {
        this.nameCompanyName = nameCompanyName;
    }
    //-------------

    //getters and setters - cpfCnpj
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    //-------------

    //getters and setters - supervisors
    public List<SupervisorResponseDto> getSupervisors(){
        return this.supervisors;
    }
    public void setSupervisors(List<SupervisorResponseDto> supervisors){
        this.supervisors = supervisors;
    }
    //-------------

    public void ClientToClientResponseDto(Client client){
        this.nameCompanyName = client.getNameCompanyName();
        this.cpfCnpj =client.getCpfCnpj();
        this.setSupervisors(this.toSupervisorsDto(client));

    }

    private List<SupervisorResponseDto> toSupervisorsDto(Client client){
        return
                client.getSupervisors().stream().map(s ->
                {
                    SupervisorResponseDto srdto= new SupervisorResponseDto();
                    srdto.toSupervisorResponseDto(s);
                    return srdto;
                }).collect(Collectors.toList());
    }


}
