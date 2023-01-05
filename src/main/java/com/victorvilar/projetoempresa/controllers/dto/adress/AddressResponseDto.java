package com.victorvilar.projetoempresa.controllers.dto.adress;

public class AddressResponseDto {

    private String addressName;
    private String addressNumber;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
    private String clientId;

    public AddressResponseDto() {
    }

    public AddressResponseDto(String addressName, String addressNumber, String complement, String zipCode, String city, String state, String clientId) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.clientId = clientId;
    }
}
