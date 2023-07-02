package com.victorvilar.projetoempresa.domain;


import com.victorvilar.projetoempresa.enums.VechicleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

/**
 * REPRESENTAR UM VEICULO -- todo
 */
public class Vechicle {

    private String id;
    //tipo de Veiculo
    @Enumerated(EnumType.STRING)
    private VechicleType type;
    //placa XXXX-XXXX
    private String plate;
    //revanam
    private String renavam;
    //url do ultimo crlv emitido
    private String validCrlvUrl;


    /**
     * ABASTECIMENTOS REALIZADOS
     */
    @OneToMany
    List<Fill> fills = new ArrayList<>();

    /**
    *DESCARTES REALIZADOS
    */
    @OneToMany
    List<Tratament> tratamentList = ArrayList<>();
}
