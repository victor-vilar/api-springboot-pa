package com.victorvilar.projetoempresa.controllers.dto.adress;

public class AddressCreateDto {

    private Long id;
    private String addressName;
    private String addressNumber;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
    private boolean requiresCollection;
    private String customerId;


    public AddressCreateDto() {

    }

    public AddressCreateDto(Long id,
                            String addressName,
                            String addressNumber,
                            String complement,
                            String zipCode,
                            String city,
                            String state,
                            boolean requiresCollection,
                            String customerId) {
        this.id = id;
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.requiresCollection = requiresCollection;
        this.customerId = customerId;
    }

    //getters e setters - id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //--------------

    //getters e setters - addressName
    public String getAddressName() {
        return addressName;
    }
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    //--------------

    //getters e setters - addressNumber
    public String getAddressNumber() {
        return addressNumber;
    }
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
    //--------------

    //getters e setters - complement
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    //--------------

    //getters e setters - requiredCollection
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    //--------------

    //getters e setters - city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    //--------------

    //getters e setters - state
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    //--------------

    //getters e setters - requiredCollection
    public boolean isRequiresCollection() {
        return requiresCollection;
    }
    public void setRequiresCollection(boolean requiresCollection) {
        this.requiresCollection = requiresCollection;
    }
    //--------------

    //getters and setters - customerId
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    //--------------
}
