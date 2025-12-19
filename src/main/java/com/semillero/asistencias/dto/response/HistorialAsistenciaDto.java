package com.semillero.asistencias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistorialAsistenciaDto {

    private Long id;
    private String fecha;
    private String horaEntrada;
    private String horaSalida;
    private boolean mcaJustificada;
    private String estado;

    //Constructor jpql
    public HistorialAsistenciaDto(Long id, LocalDate fecha, LocalDateTime horaEntrada, LocalDateTime horaSalida, char mcaJustificada, String estado) {
        this.id = id;
        this.fecha = fecha.toString();
        this.horaEntrada = horaEntrada != null ? horaEntrada.toString() : "-";
        this.horaSalida = horaSalida != null ? horaSalida.toString() : "-";
        this.mcaJustificada = mcaJustificada == 'S' ? true : false;
        this.estado = estado;
    }

}
