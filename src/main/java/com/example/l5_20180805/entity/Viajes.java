package com.example.l5_20180805.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "viajes")
public class Viajes {
    @Id
    @Column(name = "idViajes", nullable = false)
    private Integer idViajes;

    @Column(name = "puntoRecojo")
    private String companyName;

    @Column(name = "cantPersonas")
    private String cantPersonas;

    @Column(name = "cantPerros")
    private String cantPerros;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idLugares")
    private Lugares lugares;

}
