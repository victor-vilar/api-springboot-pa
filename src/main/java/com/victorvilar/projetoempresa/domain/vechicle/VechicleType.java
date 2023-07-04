package com.victorvilar.projetoempresa.domain.vechicle;

public enum VechicleType {

    CAMINHAO_COMPACTADOR("Caminhão Compactador"),
    CAMINHAO_POLIGUINDATE("Caminhão Poliguindaste"),
    CAMINHAO_ROLLON_ROLLOFF("Caminhão RollOn RollOff"),
    CAMINHAO_BAU("Caminhão Báu"),
    CAMINHAO_TANQUE("Caminhão Tanque"),
    FIORINO_FURGAO("Fiorino Furgão");

    private String type;

    VechicleType(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }


}