package br.com.landtec.entities;

import javax.persistence.*;

@Entity
@Table(name="contracts")
public class Contract {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String validity;

}
