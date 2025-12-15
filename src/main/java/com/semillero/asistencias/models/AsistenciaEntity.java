package com.semillero.asistencias.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "asistencias")
public class AsistenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="hora_entrada")
    private LocalDateTime horaEntrada;

    @Column(name="hora_salida")
    private LocalDateTime horaSalida;

    @Column(name="mca_justificada")
    private char mcaJustificada;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private AsistenciaEstadoEntity estado;

    @ManyToOne
    @JoinColumn(name = "id_admin")    
    private User admin;

    @Column(name="fecha_revision")
    private LocalDateTime fechaRevision;
}
