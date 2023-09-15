package com.example.l5_20180805.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lugares")
public class Lugares {
    @Id
    @Column(name = "idLugares", nullable = false)
    private Integer idPersona;

    @Column(name = "nombreLugar")
    private String nombreLugar;

    @Column(name = "descripLugar")
    private String descripLugar;

    @Column(name = "fechaLugar")
    private String fechaLugar;

}
