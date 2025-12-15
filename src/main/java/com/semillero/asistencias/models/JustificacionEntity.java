package com.semillero.asistencias.models;

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
@Table(name = "justificaciones")
public class JustificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;
    
    @Column(name="fecha")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoJustificacionEntity tipoJustificacion;

    @Column(name="comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private JustificacionEstadosEntity estado;

    @ManyToOne
    @JoinColumn(name = "id_admin")    
    private User admin;

    @Column(name="fecha_revision")
    private LocalDateTime fechaRevision;
    
}
