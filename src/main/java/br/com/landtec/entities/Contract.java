package br.com.landtec.entities;

import javax.persistence.*;
/**
 * Class that represents the contract of a Client
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Entity
@Table(name="contracts")
public class Contract {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String validity;

}
