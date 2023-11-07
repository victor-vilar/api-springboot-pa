package com.victorvilar.projetoempresa.dto.serviceorder;

import java.util.UUID;

public class ServiceOrderResponseDto {

    private String osNumber;
    public void setOsNumber(UUID number){
        this.osNumber = number.toString();
    }

    public String getOsNumber(){
        return this.osNumber;
    }
}
