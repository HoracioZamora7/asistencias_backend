package com.semillero.asistencias.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaResponseDto {

    private Long id;
    private Long idUsuario;
    private String nombreUsuario;
    private String dni;
    private String fecha;
    private String horaEntrada;
    private String horaSalida;
    private boolean mcaJustificada;
    private String estado;

    AsistenciaResponseDto(Long id, Long idUsuario, String nombreUsuario, String dni, LocalDate fecha, LocalDateTime horaEntrada, LocalDateTime horaSalida, char mcaJustificada, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.dni = dni;
        this.fecha = fecha.toString();
        this.horaEntrada = horaEntrada != null ? horaEntrada.toString() : "-";
        this.horaSalida = horaSalida != null ? horaSalida.toString() : "-";
        this.mcaJustificada = mcaJustificada == 'S' ? true : false;
        this.estado = estado;
    }
}
