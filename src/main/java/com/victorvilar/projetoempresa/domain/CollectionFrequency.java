package com.victorvilar.projetoempresa.domain;

import com.victorvilar.projetoempresa.enums.Weekday;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CollectionFrequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Set<Weekday> days = new HashSet<>();

    private Frequency;


}
