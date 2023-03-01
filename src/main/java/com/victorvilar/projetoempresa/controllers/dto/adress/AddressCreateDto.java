package com.victorvilar.projetoempresa.controllers.dto.adress;

public class AddressCreateDto {

    private String addressName;
    private String addressNumber;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
    private boolean requiresCollection;


    public AddressCreateDto() {

    }

    public AddressCreateDto(String addressName, String addressNumber, String complement, String zipCode, String city, String state, boolean requiresCollection) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.requiresCollection = requiresCollection;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //getters e setters - requiredCollection
    public boolean isRequiresCollection() {
        return requiresCollection;
    }
    public void setRequiresCollection(boolean requiresCollection) {
        this.requiresCollection = requiresCollection;
    }
    //--------------
}
