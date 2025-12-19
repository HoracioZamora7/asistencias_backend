package com.semillero.asistencias.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.semillero.asistencias.dto.response.AsistenciaResponseDto;
import com.semillero.asistencias.dto.response.HistorialAsistenciaDto;

public interface iAsistenciaService {

    AsistenciaResponseDto checkIn(Long idUsuario);
    AsistenciaResponseDto checkOut(Long idUsuario);
    Optional<AsistenciaResponseDto> findByIdUsuarioAndFechaActual(Long idUsuario);
    Page<HistorialAsistenciaDto> getHistorialByIdUsuario(Long idUsuario, Integer page, Integer size, LocalDate fechaInicio, LocalDate fechaFin);


}
