package com.semillero.asistencias.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JustificacionResponseDto {

    private Long id;
    private String fecha;
    private Long idUsuario;
    private String username;
    private String nombreEmpleado;
    private String dni;
    private String tipo;
    private String comentario;
    private String estado;
    private String fechaRevision;
    
    public JustificacionResponseDto(Long id, LocalDateTime fecha, Long idUsuario,  String username, String nombreEmpleado, String dni, String tipo, String comentario, String estado, LocalDateTime fechaRevision) {
        this.id = id;
        this.fecha = fecha.toString();
        this.idUsuario = idUsuario;
        this.username = username;
        this.nombreEmpleado = nombreEmpleado;
        this.dni = dni;
        this.tipo = tipo;
        this.comentario = comentario;
        this.estado = estado;
        this.fechaRevision = fechaRevision != null ? fechaRevision.toString() : "-";
    }
}
