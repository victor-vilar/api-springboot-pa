package com.victorvilar.projetoempresa.enums;

public enum StatusInformation {

    ATIVO(1),
    CANCELADO(2),
    PENDENTE(3);

    private final int id;

    StatusInformation(int id){
        this.id =id;
    }


    public int getId(){
        return this.id;
    }

    public static StatusInformation getByStatusInformation(Integer id){
        for(StatusInformation status : values()){
            if(status.getId() == id){
                return status;
            }
        }
        return null;
    }

}
