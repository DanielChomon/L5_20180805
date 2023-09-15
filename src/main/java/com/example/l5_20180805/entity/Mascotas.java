package com.example.l5_20180805.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @Column(name = "idMascotas", nullable = false)
    private Integer idMascotas;

    @Column(name = "nombreMascota")
    private String nombreMascota;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private String edad;

    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;

    @Column(name = "vacunado")
    private String vacunado;

    @Column(name = "desparasitado")
    private String desparasitado;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;
}
