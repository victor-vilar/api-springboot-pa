package com.victorvilar.projetoempresa.domain.vechicle;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * REPRESENTAR UM VEICULO -- todo
 */
public class Vechicle {

    private String id;
    //tipo de Veiculo
    @Enumerated(EnumType.STRING)
    private VechicleType type;

    //placa XXXX-XXXX
    @Column(nullable = false)
    private String plate;

    //renavam
    private String renavam;

    //url do ultimo crlv emitido
    private String validCrlvUrl;


    /**
     * ABASTECIMENTOS REALIZADOS
     */
    @OneToMany
    List<Refueling> fills = new ArrayList<>();

    /**
    *DESCARTES REALIZADOS
    */
    @OneToMany
    List<Tratament> tratamentList = ArrayList<>();
}
