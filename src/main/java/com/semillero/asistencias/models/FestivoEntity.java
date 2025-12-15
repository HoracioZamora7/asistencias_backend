package com.semillero.asistencias.models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "festivos")
public class FestivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="dia")
    private Byte dia;

    @Column(name="mes")
    private Byte mes;

    @Column(name="mca_repetible")
    private char mcaRepetible;

    @Column(name="fecha_efecto")
    private LocalDate fechaEfecto;

    @Column(name="descripcion") 
    private String descripcion;
}
